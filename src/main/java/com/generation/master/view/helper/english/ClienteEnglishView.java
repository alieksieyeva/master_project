package com.generation.master.view.helper.english;

import com.generation.master.model.entity.Cliente;

public class ClienteEnglishView
{
	public String render (Cliente c)
	{
		return "Client: "+c.getNome()+" "+c.getCognome()+", email: "+c.getEmail();
	}

}
