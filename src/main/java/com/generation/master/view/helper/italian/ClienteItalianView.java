package com.generation.master.view.helper.italian;

import com.generation.master.model.entity.Cliente;

public class ClienteItalianView
{
	public String render (Cliente c)
	{
		return "Cliente: "+c.getNome()+" "+c.getCognome()+", email: "+c.getEmail();
	}
}
