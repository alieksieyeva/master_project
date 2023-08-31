package com.generation.master;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.master.helper.DeleteHelper;
import com.generation.master.helper.InsertHelper;
import com.generation.master.helper.ReadHelper;
import com.generation.master.helper.UpdateHelper;
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
	
	InsertHelper insHelp;
	ReadHelper rHelp;
	UpdateHelper updHelp;
	DeleteHelper dHelp;
	
	public void init() throws FileNotFoundException
	{
		view = new ViewItalian();
		scanner = new Scanner (System.in);//"apri uno scanner che legga da tastiera"
		di = view.getDictionary();
		
		insHelp = new InsertHelper(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		rHelp = new ReadHelper(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		updHelp = new UpdateHelper(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		dHelp = new DeleteHelper(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		init();
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
				case "elimina":
					_deleteById();
				break;
				case "esci":
					System.out.println(di.get("GOOD_BYE"));
				break;
				default:
					System.out.println(di.get("INVALID_COMMAND"));
			}
			
			
		}while(!cmd.equals(di.get("QUIT")));
		
	}

	private void _deleteById() 
	{
		dHelp.deleteById();
		
	}

	private void _addComponent() 
	{
		updHelp.addComponent();
	}

	private void _insert() 
	{
		insHelp.insert();//deleghiamo tutto il lavoro di scrittura sul db alla classe insertHelper che contiene tutti i metodi
	}

	private void _findById() 
	{
		rHelp.findById();
	}


}
