package com.generation.master.helper;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Dispositivo;
import com.generation.master.model.entity.Pc;
import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.ComponenteRepository;
import com.generation.master.model.repository.DispositivoRepository;
import com.generation.master.model.repository.PcRepository;
import com.generation.master.view.ViewItalian;
//questa classe non nasce vuota, estendendo genericHelper eredita 
//le sue proprietà e metodi
//insert Helper is_a genericHelper ma specializzato, sa fare più cose

public class InsertHelper extends GenericHelper
{
	
	public InsertHelper(ViewItalian view, Scanner scanner, Map<String, String> di, ClienteRepository clRepo,
			PcRepository pcRepo, ComponenteRepository comRepo, DispositivoRepository disRepo)
	{
		//la costruzione dell'oggetto InsertHelper viene delegata alla classe padre (il supertipo di insertHelper)
		super(view, scanner, di, clRepo, pcRepo, comRepo, disRepo);
		
	}

	public void insert() 
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

}
