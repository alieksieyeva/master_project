package com.generation.master.helper;

import java.util.Map;
import java.util.Scanner;

import com.generation.master.model.repository.ClienteRepository;
import com.generation.master.model.repository.ComponenteRepository;
import com.generation.master.model.repository.DispositivoRepository;
import com.generation.master.model.repository.PcRepository;
import com.generation.master.view.ViewItalian;
//questa classe contiene ciò che è comune tra tutte le classi helper: proprietà e costruttore
public class GenericHelper 
{
	ViewItalian view;
	Scanner scanner;
	Map<String, String> di;
	
	ClienteRepository clRepo;
	PcRepository pcRepo;
	ComponenteRepository comRepo;
	DispositivoRepository disRepo;
	
	public GenericHelper(ViewItalian view, Scanner scanner, Map<String, String> di, ClienteRepository clRepo,
			PcRepository pcRepo, ComponenteRepository comRepo, DispositivoRepository disRepo) 
	{
		this.view = view;
		this.scanner = scanner;
		this.di = di;
		this.clRepo = clRepo;
		this.pcRepo = pcRepo;
		this.comRepo = comRepo;
		this.disRepo = disRepo;
	}
}
