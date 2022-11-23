package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.enumerations.Sexe;

@Entity
@Table
public class Athlete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM", length = 155)
	private String nom;
	
	@Column(name = "SEXE")
	@Enumerated(value = EnumType.STRING)
	private Sexe sexe;
	
	@Column(name="TAILLE")
	private Float taille;
	
	@Column(name="POIDS")
	private Float poids;
	
	@Column(name="AGE")
	private int age;
	
}
