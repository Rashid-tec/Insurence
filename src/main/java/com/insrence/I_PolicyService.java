package com.insrence;

import java.util.List;

import com.insrence.request.PolicyRequest;

public interface I_PolicyService {
	
	  PolicyResponse createPolicy(PolicyRequest request);
	   // PolicyResponse updatePolicy(Long id, PolicyResponse request);
	    List<PolicyResponse> getAllPolicies();
	    PolicyResponse getPolicyById(Long id);
		PolicyResponse updatePolicy(Long id, PolicyRequest request);
}
