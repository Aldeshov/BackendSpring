package com.example.demo.repositories;

import com.example.demo.models.MaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, Long> {}