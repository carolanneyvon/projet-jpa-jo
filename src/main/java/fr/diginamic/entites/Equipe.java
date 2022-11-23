package fr.diginamic.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM", length = 155)
	private String nom;
	
	/** Banniere : plusieurs équipes posséde une bannière */
	@ManyToOne
	@JoinColumn(name="ID_BANNIERE")
	private Banniere banniere;
	
	/** ATHLETE_EQUIPE */
	@ManyToMany
	@JoinTable(name = "ATHLETE_EQUIPE", 
		joinColumns = @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"))
	private List<Athlete> athletes = new ArrayList<Athlete>();
	
}
