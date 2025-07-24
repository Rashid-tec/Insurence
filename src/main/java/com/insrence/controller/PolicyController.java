package com.insrence.controller;



import com.insrence.I_PolicyService;
import com.insrence.PolicyResponse;
import com.insrence.request.PolicyRequest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private I_PolicyService service;

    @PostMapping("/save")
    public PolicyResponse create(@Valid @RequestBody PolicyRequest request) {
        System.out.println("API is hiting yaha tk======");
    	return service.createPolicy(request);
    }

    @PutMapping("/{id}")
    public PolicyResponse update(@PathVariable Long id, @Valid @RequestBody PolicyRequest request) {
        return service.updatePolicy(id, request);
    }

    @GetMapping
    public List<PolicyResponse> getAll() {
        return service.getAllPolicies();
    }

    @GetMapping("/{id}")
    public PolicyResponse getById(@PathVariable Long id) {
        return service.getPolicyById(id);
    }
}

