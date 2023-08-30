package com.generation.master.view.helper.english;

import com.generation.master.model.entity.Pc;

public class PcEnglishView 
{
	public String render(Pc pc)
	{
		StringBuilder s = new StringBuilder();
		s.append("Pc ordered in ");
		s.append(pc.getDataOrdine());
		s.append(" ETA: ");
		s.append(pc.getDataConsegnaPrevista());
		return s.toString();
	}
}
