package com.generation.master.helper;

import java.util.Map;
import java.util.Scanner;

import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Pc;
import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.ComponenteRepository;
import com.generation.master.model.repository.DispositivoRepository;
import com.generation.master.model.repository.PcRepository;
import com.generation.master.view.ViewItalian;

public class UpdateHelper extends GenericHelper 
{
	
	public UpdateHelper(ViewItalian view, Scanner scanner, Map<String, String> di, ClienteRepository clRepo,
			PcRepository pcRepo, ComponenteRepository comRepo, DispositivoRepository disRepo)
	{
		super(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		
	}

	public void addComponent() 
	{
		System.out.println(di.get("INSERT_PC_ID"));
		Integer id =Integer.parseInt(scanner.nextLine());
		System.out.println(di.get("INSERT_MODEL"));
		String model = scanner.nextLine();
		Pc pc = pcRepo.findById(id).get();
		
		Componente component = comRepo.findByModello(model);
		
		if(pc==null || component==null)
		{
			System.out.println(di.get("NOT_FOUND"));
			return;
		}
		pc.getComponenti().add(component);
		pcRepo.save(pc);
		System.out.println(di.get("SUCCESS"));
	}

}
