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

public class ReadHelper extends GenericHelper
{
	
	public ReadHelper(ViewItalian view, Scanner scanner, Map<String, String> di, ClienteRepository clRepo,
			PcRepository pcRepo, ComponenteRepository comRepo, DispositivoRepository disRepo) 
	{
		super(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		
	}

	public void findById() 
	{
		System.out.println(di.get("INSERT_TYPE"));
		String type = scanner.nextLine();
		System.out.println(di.get("INSERT_ID"));
		int id = Integer.parseInt(scanner.nextLine());
		switch(type.toLowerCase())
		{
			case "cliente":
				Optional <Cliente> c = clRepo.findById(id);
				if(c.isPresent())
					System.out.println(view.renderCliente(c.get()));
				else
					System.out.println(di.get("NOT_FOUND"));
			break;
			case "pc":
				Optional <Pc> pc = pcRepo.findById(id);
				if(pc.isPresent())
					System.out.println(view.renderPc(pc.get()));
				else
					System.out.println(di.get("NOT_FOUND"));
			break;
			case "componente":
				Optional <Componente> comp = comRepo.findById(id);
				if(comp.isPresent())
					System.out.println(view.renderComponente(comp.get()));
				else
					System.out.println(di.get("NOT_FOUND"));
			break;
			case "dispositivo":
				Optional <Dispositivo> dis = disRepo.findById(id);
				if(dis.isPresent())
					System.out.println(view.renderDispositivo(dis.get()));
				else
					System.out.println(di.get("NOT_FOUND"));
			break;
			default:
				System.out.println(di.get("WRONG_TYPE"));
		}
		
	}


}
