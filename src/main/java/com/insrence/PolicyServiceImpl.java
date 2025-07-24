package com.insrence;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insrence.entity.Policy;
import com.insrence.request.PolicyRequest;

@Service
public class PolicyServiceImpl implements I_PolicyService{

	@Autowired
	private PoliceRepoistry policyrepositry;
	@Override
	public PolicyResponse createPolicy(PolicyRequest request) {
		
		Policy p=new Policy();
		setValues(p,request);
		return  toResponse(policyrepositry.save(p)) ;
	}

	

	@Override
	public List<PolicyResponse> getAllPolicies() {
		
		return policyrepositry.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
		
	}

	@Override
	public PolicyResponse getPolicyById(Long id) {
		
		  
		        Policy policy = policyrepositry.findById(id)
		                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with ID " + id));
		        return toResponse(policy);
		    }
	
	private void setValues(Policy policy, PolicyRequest request)
	{
		policy.setHolderName(request.getHolderName());
		policy.setType(request.getType());
		policy.setStartDate(request.getStartDate());
		policy.setEndDate(request.getEndDate());
		policy.setPremiumAmount(request.getPremiumAmount());
	}

	private PolicyResponse toResponse(Policy policy)
	{
		PolicyResponse response=new PolicyResponse();
		response.setId(policy.getId());
		response.setHolderName(policy.getHolderName());
		response.setStartDate(policy.getStartDate());
		response.setEndDate(policy.getEndDate());
		response.setPremiumAmount(policy.getPremiumAmount());
		response.setType(policy.getType());
		return response;
		
	}

	@Override
    public PolicyResponse updatePolicy(Long id, PolicyRequest request) {
        Policy policy = policyrepositry.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with ID " + id));
        setValues(policy, request);
        return toResponse(policyrepositry.save(policy));
    }
	
	
	

}
