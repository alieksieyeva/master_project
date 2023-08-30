package com.generation.master.view;

import java.io.FileNotFoundException;
import java.util.Map;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Dispositivo;
import com.generation.master.model.entity.Pc;
import com.generation.master.view.helper.english.ClienteEnglishView;
import com.generation.master.view.helper.english.ComponenteEnglishView;
import com.generation.master.view.helper.english.DispositivoEnglishView;
import com.generation.master.view.helper.english.EnglishDictionary;
import com.generation.master.view.helper.english.PcEnglishView;

import lombok.Getter;

public class ViewEnglish 
{
	private ClienteEnglishView clView;
	private ComponenteEnglishView comView;
	private DispositivoEnglishView disView;
	private PcEnglishView pcView;
	@Getter
	private Map <String, String> dictionary;
	
	public ViewEnglish () throws FileNotFoundException
	{
		EnglishDictionary engdi = new EnglishDictionary();
		dictionary= engdi.getDictionary();
	}
	
	public String renderPc (Pc pc)
	{
		StringBuilder s = new StringBuilder();
		s.append(pcView.render(pc));
		s.append("\nComponents list:");
		
		for(Componente c: pc.getComponenti())
			s.append("\n"+comView.render(c));
		
		s.append("\nBought by: "+clView.render(pc.getAcquirente()));
		
		return s.toString();
	}
	
	public String renderCliente (Cliente c)
	{
		StringBuilder s = new StringBuilder();
		s.append(clView.render(c));
		s.append("\nList of acquired pcs: ");
		
		for(Pc pc: c.getPcAcquistati())
			s.append("\n"+pcView.render(pc));
		
		s.append("\nList of acquired devices: ");
		for(Dispositivo d: c.getDispositiviAcquistati())
			s.append("\n"+disView.render(d));
		
		return s.toString();
	}
	
	public String renderDispositivo(Dispositivo d)
	{
		StringBuilder s = new StringBuilder();
		s.append(disView.render(d));
	
		s.append("\nBought by: "+clView.render(d.getAcquirente()));
		
		return s.toString();
	}
	
	public String renderComponente (Componente c) 
	{
		StringBuilder s = new StringBuilder();
		s.append(comView.render(c));
		
		s.append("\nUsed in:");
		
		for (Pc pc: c.getPcs())
			s.append("\n"+pcView.render(pc));
		
		return s.toString();
	}
}
