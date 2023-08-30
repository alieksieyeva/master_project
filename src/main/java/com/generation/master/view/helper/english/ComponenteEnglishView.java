package com.generation.master.view.helper.english;

import com.generation.master.model.entity.Componente;

public class ComponenteEnglishView 
{
	public String render (Componente c)
	{
		return "Component "+c.getTipo()+", "+c.getModello()+", price: "+c.getPrezzo();
	}
}
