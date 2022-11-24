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
public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM", length = 155)
	private String nom;

	/** Constructeur
	 * 
	 */
	public Sport() {
		super();
	}
	
	

	/** Constructeur
	 * @param nom
	 */
	public Sport(String nom) {
		super();
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Sport [id=" + id + ", nom=" + nom + "]";
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
	
	
}
