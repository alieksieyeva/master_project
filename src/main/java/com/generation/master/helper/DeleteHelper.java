package com.generation.master.helper;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Dispositivo;
import com.generation.master.model.entity.Pc;
import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.ComponenteRepository;
import com.generation.master.model.repository.DispositivoRepository;
import com.generation.master.model.repository.PcRepository;
import com.generation.master.view.ViewItalian;

public class DeleteHelper extends GenericHelper
{

	public DeleteHelper(ViewItalian view, Scanner scanner, Map<String, String> di, ClienteRepository clRepo,
			PcRepository pcRepo, ComponenteRepository comRepo, DispositivoRepository disRepo) 
	{
		super(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		
	}
	
	public void deleteById() 
	{
		System.out.println(di.get("INSERT_TYPE"));
		String type = scanner.nextLine();
		System.out.println(di.get("INSERT_ID"));
		int id = Integer.parseInt(scanner.nextLine());
		switch(type.toLowerCase())
		{
			case "cliente":
				clRepo.deleteById(id);
			break;
			case "pc":
				pcRepo.deleteById(id);
			break;
			case "componente":
				comRepo.deleteById(id);
			break;
			case "dispositivo":
				disRepo.deleteById(id);
			break;
			default:
				System.out.println(di.get("WRONG_TYPE"));
		}
		
	}
}
