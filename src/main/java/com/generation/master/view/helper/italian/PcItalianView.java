package com.generation.master.view.helper.italian;

import com.generation.master.model.entity.Pc;

public class PcItalianView
{

	public String render(Pc pc)
	{
		StringBuilder s = new StringBuilder();
		s.append("Pc ordinato il ");
		s.append(pc.getDataOrdine());
		s.append(" e con consegna prevista il ");
		s.append(pc.getDataConsegnaPrevista());
		return s.toString();
	}
}
