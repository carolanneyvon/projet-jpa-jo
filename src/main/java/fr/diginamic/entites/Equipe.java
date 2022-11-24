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

/**
 * @author Carolanne
 *
 */
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

	/** Constructeur
	 * 
	 */
	public Equipe() {
		super();
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nom=" + nom + ", banniere=" + banniere + ", athletes=" + athletes + "]";
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

	/** Getter pour l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter pour l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter pour l'attribut banniere
	 * @return the banniere
	 */
	public Banniere getBanniere() {
		return banniere;
	}

	/** Setter pour l'attribut banniere
	 * @param banniere the banniere to set
	 */
	public void setBanniere(Banniere banniere) {
		this.banniere = banniere;
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
