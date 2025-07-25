package com.insrence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.insrence.entity.Policy;
import com.insrence.request.PolicyRequest;

public class PolicyServiceImplTest {
	@Mock
	private PoliceRepoistry policeRepository;
	 @InjectMocks
	    private PolicyServiceImpl policyService;
	 @BeforeEach
	 void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	 @Test
	    void testCreatePolicy() {
	        PolicyRequest request = getSamplePolicyRequest();
	        Policy savedPolicy = getSamplePolicy(1L);

	        when(policeRepository.save(any(Policy.class))).thenReturn(savedPolicy);

	        PolicyResponse response = policyService.createPolicy(request);

	        assertNotNull(response);
	        assertEquals("John Doe", response.getHolderName());
	        assertEquals("Health", response.getType());
	    }
	 @Test
	    void testUpdatePolicy() {
	        Policy existingPolicy = getSamplePolicy(1L);
	        PolicyRequest request = getSamplePolicyRequest();
	        Policy updatedPolicy = getSamplePolicy(1L);

	        when(policeRepository.findById(1L)).thenReturn(Optional.of(existingPolicy));
	        when(policeRepository.save(any(Policy.class))).thenReturn(updatedPolicy);

	        PolicyResponse response = policyService.updatePolicy(1L, request);

	        assertEquals("John Doe", response.getHolderName());
	        assertEquals("Health", response.getType());
	    }
	 @Test
	    void testGetPolicyById_NotFound() {
	        when(policeRepository.findById(99L)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(PolicyNotFoundException.class, () -> {
	            policyService.getPolicyById(99L);
	        });

	        assertTrue(exception.getMessage().contains("Policy not found"));
	    }
	 private PolicyRequest getSamplePolicyRequest() {
		    PolicyRequest request = new PolicyRequest();
		    request.setHolderName("John Doe");
		    request.setType("Health");
		    request.setStartDate(LocalDate.of(2024, 1, 1));
		    request.setEndDate(LocalDate.of(2025, 1, 1));
		    request.setPremiumAmount((10000));
		    return request;
		}

		private Policy getSamplePolicy(Long id) {
		    Policy policy = new Policy();
		    policy.setId(id);
		    policy.setHolderName("John Doe");
		    policy.setType("Health");
		    policy.setStartDate(LocalDate.of(2024, 1, 1));
		    policy.setEndDate(LocalDate.of(2025, 1, 1));
		    policy.setPremiumAmount((10000));
		    return policy;
		}
	 

}
