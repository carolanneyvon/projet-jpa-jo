package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Carolanne
 *
 */
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
	
	@Column(name="STATUT", length = 1)
	private String statut;

	/** Constructeur
	 * 
	 */
	public Banniere() {
		super();
	}

	
	/** Constructeur
	 * @param cioCode
	 * @param nom
	 * @param statut
	 */
	public Banniere(String cioCode, String nom, String statut) {
		super();
		this.cioCode = cioCode;
		this.nom = nom;
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Banniere [id=" + id + ", cioCode=" + cioCode + ", nom=" + nom + ", statut=" + statut + "]";
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

	/** Getter pour l'attribut cioCode
	 * @return the cioCode
	 */
	public String getCioCode() {
		return cioCode;
	}

	/** Setter pour l'attribut cioCode
	 * @param cioCode the cioCode to set
	 */
	public void setCioCode(String cioCode) {
		this.cioCode = cioCode;
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

	/** Getter pour l'attribut statut
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/** Setter pour l'attribut statut
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	
}
