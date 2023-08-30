package com.generation.master.view.helper.italian;

import com.generation.master.model.entity.Componente;

public class ComponenteItalianView 
{
	public String render (Componente c)
	{
		return "Componente "+c.getTipo()+", "+c.getModello()+", prezzo: "+c.getPrezzo();
	}
}
