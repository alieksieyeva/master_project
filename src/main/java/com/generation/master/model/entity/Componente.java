package com.generation.master.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Componente 
{
//	id int primary key auto_increment,
//	modello varchar (100),
//	tipo varchar(100),
//	prezzo numeric (7,2)
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modello;
	private String tipo;
	private Double prezzo;
	
	@ManyToMany (mappedBy = "componenti", fetch = FetchType.EAGER)  
	private List <Pc> pcs;

}
