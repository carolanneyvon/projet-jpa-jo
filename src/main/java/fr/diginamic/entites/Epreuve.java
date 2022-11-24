package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Carolanne
 *
 */
@Entity
@Table
public class Epreuve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM", length = 155)
	private String nom;

	/** Jeux : plusieurs épreuves dans un jeu */
	@ManyToOne
	@JoinColumn(name="ID_JEUX")
	private Jeux jeux;
	
	/** Sport : plusieurs sports dans un jeu */
	@ManyToOne
	@JoinColumn(name="ID_SPORT")
	private Sport sport;

	/** Constructeur
	 * 
	 */
	public Epreuve() {
		super();
	}

	@Override
	public String toString() {
		return "Epreuve [id=" + id + ", nom=" + nom + ", jeux=" + jeux + ", sport=" + sport + "]";
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

	/** Getter pour l'attribut jeux
	 * @return the jeux
	 */
	public Jeux getJeux() {
		return jeux;
	}

	/** Setter pour l'attribut jeux
	 * @param jeux the jeux to set
	 */
	public void setJeux(Jeux jeux) {
		this.jeux = jeux;
	}

	/** Getter pour l'attribut sport
	 * @return the sport
	 */
	public Sport getSport() {
		return sport;
	}

	/** Setter pour l'attribut sport
	 * @param sport the sport to set
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
}
