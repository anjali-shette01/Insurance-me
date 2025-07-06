package com.insuranceme.insurance_me.controller;

import com.insuranceme.insurance_me.model.Policy;
import com.insuranceme.insurance_me.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyRepository repo;

    @PostMapping("/createPolicy")
    public ResponseEntity<Policy> create(@RequestBody Policy policy) {
        return ResponseEntity.ok(repo.save(policy));
    }

    @PutMapping("/updatePolicy/{id}")
    public ResponseEntity<Policy> update(@PathVariable Long id, @RequestBody Policy updated) {
        Optional<Policy> optional = repo.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Policy existing = optional.get();
        existing.setPolicyHolderName(updated.getPolicyHolderName());
        existing.setType(updated.getType());
        existing.setPremiumAmount(updated.getPremiumAmount());
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());

        return ResponseEntity.ok(repo.save(existing));
    }

    @GetMapping("/viewPolicy/{id}")
    public ResponseEntity<Policy> view(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePolicy/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
