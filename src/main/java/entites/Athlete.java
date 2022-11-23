package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Athlete {
	
	@Id
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
