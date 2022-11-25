package fr.diginamic.entites;

import java.util.ArrayList;
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

/**
 * @author Carolanne
 *
 */
@Entity
@Table
public class Jeux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ANNEE")
	private int annee;
	
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

	/** Constructeur
	 * 
	 */
	public Jeux() {
		super();
	}
	
	

	/** Constructeur
	 * @param annee
	 * @param saison
	 * @param ville
	 */
	public Jeux(int annee, Saison saison, String ville) {
		super();
		this.annee = annee;
		this.saison = saison;
		this.ville = ville;
	}



	@Override
	public String toString() {
		return "Jeux [id=" + id + ", annee=" + annee + ", saison=" + saison + ", ville=" + ville + ", athletes="
				+ athletes + "]";
	}

	/** Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter pour l'attribut annee
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/** Setter pour l'attribut annee
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/** Getter pour l'attribut saison
	 * @return the saison
	 */
	public Saison getSaison() {
		return saison;
	}

	/** Setter pour l'attribut saison
	 * @param saison the saison to set
	 */
	public void setSaison(Saison saison) {
		this.saison = saison;
	}

	/** Getter pour l'attribut ville
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter pour l'attribut ville
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Getter pour l'attribut athletes
	 * @return the athletes
	 */
	public List<Athlete> getAthletes() {
		return athletes;
	}

	/** Setter pour l'attribut athletes
	 * @param athletes the athletes to set
	 */
	public void setAthletes(List<Athlete> athletes) {
		this.athletes = athletes;
	}
	
	

}
