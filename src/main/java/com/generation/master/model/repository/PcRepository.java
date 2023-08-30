package com.generation.master.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.master.model.entity.Pc;

public interface PcRepository extends JpaRepository <Pc, Integer>
{

}
