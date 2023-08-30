package com.generation.master.view;

import java.io.FileNotFoundException;
import java.util.Map;

import com.generation.master.model.entity.Cliente;
import com.generation.master.model.entity.Componente;
import com.generation.master.model.entity.Dispositivo;
import com.generation.master.model.entity.Pc;
import com.generation.master.view.helper.italian.ClienteItalianView;
import com.generation.master.view.helper.italian.ComponenteItalianView;
import com.generation.master.view.helper.italian.DispositivoItalianView;
import com.generation.master.view.helper.italian.ItalianDictionary;
import com.generation.master.view.helper.italian.PcItalianView;

import lombok.Getter;

public class ViewItalian
{
	private ClienteItalianView clView;
	private ComponenteItalianView comView;
	private DispositivoItalianView disView;
	private PcItalianView pcView;
	@Getter
	private Map <String, String> dictionary;
	
	public ViewItalian () throws FileNotFoundException
	{
		ItalianDictionary itadi = new ItalianDictionary();
		dictionary= itadi.getDictionary();
	}
	
	public String renderPc (Pc pc)
	{
		StringBuilder s = new StringBuilder();
		s.append(pcView.render(pc));
		s.append("\nLista componenti:");
		
		for(Componente c: pc.getComponenti())
			s.append("\n"+comView.render(c));
		
		s.append("\nAcquistato da: "+clView.render(pc.getAcquirente()));
		
		return s.toString();
	}
	
	public String renderCliente (Cliente c)
	{
		StringBuilder s = new StringBuilder();
		s.append(clView.render(c));
		s.append("\nLista pc acquistati: ");
		
		for(Pc pc: c.getPcAcquistati())
			s.append("\n"+pcView.render(pc));
		
		s.append("\nLista dispositivi acquistati: ");
		for(Dispositivo d: c.getDispositiviAcquistati())
			s.append("\n"+disView.render(d));
		
		return s.toString();
	}
	
	public String renderDispositivo(Dispositivo d)
	{
		StringBuilder s = new StringBuilder();
		s.append(disView.render(d));
	
		s.append("\nAcquistato da: "+clView.render(d.getAcquirente()));
		
		return s.toString();
	}
	
	public String renderComponente (Componente c) 
	{
		StringBuilder s = new StringBuilder();
		s.append(comView.render(c));
		
		s.append("\nUsato dai pc:");
		
		for (Pc pc: c.getPcs())
			s.append("\n"+pcView.render(pc));
		
		return s.toString();
	}
	
}
