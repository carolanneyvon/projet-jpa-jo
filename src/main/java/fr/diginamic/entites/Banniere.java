package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Banniere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CIOCODE", length = 3)
	private String cioCode;
	
	@Column(name="NOM", length = 155)
	private String nom;
	
	@Column(name="STATUT")
	private Boolean statut;

}
