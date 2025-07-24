package com.insrence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insrence.entity.Policy;

public interface PoliceRepoistry  extends JpaRepository<Policy,Long>{

}
