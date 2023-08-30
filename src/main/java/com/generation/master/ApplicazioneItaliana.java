package com.generation.master;

import java.time.LocalDate;
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
				case "inserisci":
					_insert();
				break;
				case "aggiungi componente":
					_addComponent();
				break;	
			
			}
			
			
		}while(!cmd.equals(di.get("QUIT")));
		
	}

	private void _addComponent() 
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

	private void _insert() 
	{
		System.out.println(di.get("INSERT_TYPE"));
		String type = scanner.nextLine();
		
		switch(type.toLowerCase())
		{
			case "cliente":
				_insertCliente();
			break;
			case "pc":
				_insertPc();
			break;
			case "componente":
				_insertComponente();
			break;
			case "dispositivo":
				_insertDispositivo();
			break;
			default:
				System.out.println(di.get("WRONG_TYPE"));
		}
		
		
	}

	private void _insertComponente() 
	{
		System.out.println(di.get("INSERT_COMPONENT_TYPE"));
		String type = scanner.nextLine();
		System.out.println(di.get("INSERT_MODEL"));
		String model = scanner.nextLine();
		System.out.println(di.get("INSERT_PRICE"));
		Double price =Double.parseDouble(scanner.nextLine());
		
		Componente toInsert = Componente.builder().tipo(type).modello(model).prezzo(price).build();
		comRepo.save(toInsert);
		System.out.println("SUCCESS");
		
	}

	private void _insertPc() 
	{
		System.out.println(di.get("INSERT_DATE_ORDER"));
		LocalDate dataOrdine = LocalDate.parse(scanner.nextLine());
		System.out.println(di.get("INSERT_ETA"));
		LocalDate dataConsegna = LocalDate.parse(scanner.nextLine());
		
		System.out.println(di.get("INSERT_CUSTOMER"));
		System.out.println(di.get("INSERT_NAME"));
		String nomeclient = scanner.nextLine();
		System.out.println(di.get("INSERT_SURNAME"));
		String cognome = scanner.nextLine();
		Cliente c = clRepo.findByNomeAndCognome(nomeclient, cognome);
		if(c==null)
		{
			System.out.println(di.get("NOT_FOUND"));
			return;
		}
		
		Pc toInsert =Pc.builder().dataOrdine(dataOrdine).dataConsegnaPrevista(dataConsegna).acquirente(c).build();
		pcRepo.save(toInsert);
		System.out.println("SUCCESS");
		
	}

	private void _insertDispositivo() 
	{
		System.out.println(di.get("INSERT_NAME"));
		String nome = scanner.nextLine();
		System.out.println(di.get("INSERT_PRICE"));
		Double price =Double.parseDouble(scanner.nextLine());
		
		System.out.println(di.get("INSERT_CUSTOMER"));
		System.out.println(di.get("INSERT_NAME"));
		String nomeclient = scanner.nextLine();
		System.out.println(di.get("INSERT_SURNAME"));
		String cognome = scanner.nextLine();
		Cliente c = clRepo.findByNomeAndCognome(nomeclient, cognome);
		if(c==null)
		{
			System.out.println(di.get("NOT_FOUND"));
			return;
		}
		
		Dispositivo toInsert = Dispositivo.builder().nome(nome).prezzo(price).acquirente(c).build();
		disRepo.save(toInsert);
		System.out.println("SUCCESS");
	}

	private void _insertCliente() 
	{
		
		System.out.println(di.get("INSERT_NAME"));
		String nome = scanner.nextLine();
		System.out.println(di.get("INSERT_SURNAME"));
		String cognome = scanner.nextLine();
		System.out.println(di.get("INSERT_EMAIL"));
		String email = scanner.nextLine();
		
		Cliente toInsert = Cliente.builder().nome(nome).cognome(cognome).email(email).build();
		clRepo.save(toInsert);
		
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
