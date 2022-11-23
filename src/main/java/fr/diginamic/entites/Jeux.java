package fr.diginamic.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.diginamic.enumerations.Saison;

@Entity
@Table
public class Jeux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ANNEE")
	private Date annee;
	
	@Column(name = "SAISON")
	@Enumerated(value = EnumType.STRING)
	private Saison saison;
	
	@Column(name="VILLE", length = 155)
	private String ville;
	
	/** ATHLETE_JEUX */
	@ManyToMany
	@JoinTable(name = "ATHLETE_JEUX", 
		joinColumns = @JoinColumn(name = "ID_JEUX", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"))
	private List<Athlete> athletes = new ArrayList<Athlete>();
	

}
