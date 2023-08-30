package com.generation.master;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Dispositivo;
import com.generation.master.model.entity.Pc;
import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.ComponenteRepository;
import com.generation.master.model.repository.DispositivoRepository;
import com.generation.master.model.repository.PcRepository;
import com.generation.master.view.ViewItalian;

@SpringBootApplication
public class ApplicazioneItaliana implements CommandLineRunner
{
	public static void main(String[] args) 
	{
		SpringApplication.run(MasterApplication.class, args);
	}
	
	private ViewItalian view;
	private Scanner scanner;
	private Map<String, String> di;
	@Autowired
	ClienteRepository clRepo;
	@Autowired
	PcRepository pcRepo;
	@Autowired
	ComponenteRepository comRepo;
	@Autowired
	DispositivoRepository disRepo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		view = new ViewItalian();
		scanner = new Scanner (System.in);//"apri uno scanner che legga da tastiera"
		di = view.getDictionary();
		String cmd = "";
		
		System.out.println(di.get("WELCOME"));
		do
		{
			System.out.println(di.get("INSERT_COMMAND"));
			cmd=scanner.nextLine(); //esattamente uguale a scrivere "Console.readString();"
			
			switch(cmd)
			{	//bisogna scrivere direttamente il valore, senza passare dal dizionario
				case "trova":
					_findById();	
				break;
			
			}
			
			
		}while(!cmd.equals(di.get("QUIT")));
		
	}

	private void _findById() 
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
