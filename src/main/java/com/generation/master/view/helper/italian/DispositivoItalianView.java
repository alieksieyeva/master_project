package com.generation.master.view.helper.italian;

import com.generation.master.model.entity.Dispositivo;

public class DispositivoItalianView 
{

	public String render(Dispositivo d)
	{
		String template = "Dispositivo di nome %s e di prezzo %s euro ";//%s è il segnaposto per una Stringa
		String formattata = String.format(template, d.getNome(),d.getPrezzo());
		return formattata;
	}
	
}
