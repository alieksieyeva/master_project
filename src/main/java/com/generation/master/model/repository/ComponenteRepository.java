package com.generation.master.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.master.model.entity.Componente;

public interface ComponenteRepository extends JpaRepository <Componente, Integer>
{

}
