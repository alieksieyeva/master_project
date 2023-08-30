package com.generation.master;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.PcRepository;

@SpringBootTest  //è JUnit
class MasterApplicationTests 
{
	@Autowired //si può usare autowired solo con ciò che è dichiarato come proprietà
	ClienteRepository repoCli;
	@Autowired 	
	PcRepository repoPc;
	
	@Test
	void testCliente() 
	{
		//inserimento cliente
		Cliente toInsert = 	Cliente
							.builder()
							.nome("Stefano")
							.cognome("Rubinetti")
							.email("stefano@email.com")
							.build();
		
		Cliente  inserito =repoCli.save(toInsert); //metodo save restituisce l'oggetto salvato su Db
		assert(inserito.getId()!=null);
		
		//test lettura cliente
		Cliente letto = repoCli.findById(1).get();
		assert(toInsert.getNome().equals(letto.getNome()));
		assert(toInsert.getCognome().equals(letto.getCognome()));
		assert(toInsert.getEmail().equals(letto.getEmail()));
		
		Cliente toInsert2 = 	Cliente
								.builder()
								.nome("Ferdinando")
								.cognome("Primerano")
								.email("fedinando@email.com")
								.build();
		repoCli.save(toInsert2);
		
		Cliente letto2 = repoCli.findByNomeAndCognome("Ferdinando", "Primerano");
		assert(letto2!=null);
		
		repoCli.delete(letto2);
		//ripulisco il db da tutti gli Stefano tranne quello con id =1;
		List <Cliente> all = repoCli.findAll();
		all.remove(0);
		repoCli.deleteAllInBatch(all);
	}
	@Test
	void testPc() 
	{
		
	}
	
}
