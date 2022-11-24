package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.diginamic.enumerations.Couleur;

/**
 * @author Carolanne
 *
 */
@Entity
@Table
public class Medaille {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "COULEUR")
	@Enumerated(value = EnumType.STRING)
	private Couleur couleur;
	
	/** Athlete : plusieurs médailles pour un athlète */
	@ManyToOne
	@JoinColumn(name="ID_ATHLETE")
	private Athlete athlete;
	
	/** Epreuve : plusieurs médailles pour une épreuve */
	@ManyToOne
	@JoinColumn(name="ID_EPREUVE")
	private Epreuve epreuve;

	/** Constructeur
	 * 
	 */
	public Medaille() {
		super();
	}

	@Override
	public String toString() {
		return "Medaille [id=" + id + ", couleur=" + couleur + ", athlete=" + athlete + ", epreuve=" + epreuve + "]";
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

	/** Getter pour l'attribut couleur
	 * @return the couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/** Setter pour l'attribut couleur
	 * @param couleur the couleur to set
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	/** Getter pour l'attribut athlete
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/** Setter pour l'attribut athlete
	 * @param athlete the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/** Getter pour l'attribut epreuve
	 * @return the epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

	/** Setter pour l'attribut epreuve
	 * @param epreuve the epreuve to set
	 */
	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}
	
	
}
