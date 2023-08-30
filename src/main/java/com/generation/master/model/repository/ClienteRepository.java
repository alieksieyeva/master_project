package com.generation.master.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.master.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>
{
	public Cliente findByNomeAndCognome(String nome, String cognome); //JPA ci creerà un metodo apposito per fare questa ricerca
}
