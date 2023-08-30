package com.generation.master.view.helper.english;

import com.generation.master.model.entity.Dispositivo;

public class DispositivoEnglishView 
{
	public String render(Dispositivo d)
	{
		String template = "Device named %s , price: %s euro ";//%s è il segnaposto per una Stringa
		String formattata = String.format(template, d.getNome(),d.getPrezzo());
		return formattata;
	}
}
