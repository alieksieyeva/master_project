package com.generation.master.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Dispositivo 
{
//	id int primary key auto_increment,
//	nome varchar (100),
//	prezzo numeric (7,2),
//	id_cliente int  --> non lo mettiamo come proprietà qua, in Java esprimiamo la relazione con un riferimento diretto al padre 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double prezzo;
	
	@ManyToOne(fetch = FetchType.EAGER) //quando leggi dispositivo leggi in automatico sempre il suo padre, client
	@JoinColumn(name="id_cliente")	
	private Cliente acquirente; 
	
}
