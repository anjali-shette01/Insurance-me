package com.insuranceme.insurance_me.repository;

import com.insuranceme.insurance_me.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {}
