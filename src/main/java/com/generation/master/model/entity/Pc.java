package com.generation.master.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Pc
{
//	id int primary key auto_increment,
//	data_ordine Date,
//	data_consegna_prevista Date,
//	id_cliente int
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataOrdine;
	private LocalDate dataConsegnaPrevista;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="id_cliente")	
	private Cliente acquirente;
	
	//tra componenti e pc c'è una relazione N a N
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable 	//relazione n a n viene declinata in due relazione 1 a n 
	(
		name = "componente_to_pc", 					//nome della tabella associativa in sql
		joinColumns = @JoinColumn(name = "id_pc"), //chiave esterna di tabella associativa verso questa classe --> 1 a n
		inverseJoinColumns = @JoinColumn(name = "id_componente") //chiave esterna verso l'altra tabella --> 1 a n
	)
	private List <Componente> componenti;
	
	
	
	
}
