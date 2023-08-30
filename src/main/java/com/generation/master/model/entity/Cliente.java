package com.generation.master.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //comunico a spring data jpa che questa è una classe che deve gestire (salvare e leggere dal DB)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cliente 
{
	
//	id int primary key auto_increment,
//	nome varchar (100),
//	cognome varchar(100),
//	email varchar (100)
	
	@Id //primary key
	@GeneratedValue (strategy = GenerationType.IDENTITY) //è generato in automatico come auto_increment
	private Integer id;
	private String nome;
	private String cognome;
	private String email;
	
	@OneToMany (mappedBy = "acquirente", fetch = FetchType.EAGER)
	private List <Pc> pcAcquistati;
	
	@OneToMany (mappedBy = "acquirente", fetch = FetchType.EAGER)
	private List <Dispositivo> dispositiviAcquistati;
}
