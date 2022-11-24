package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.enumerations.Sexe;

/**
 * @author Carolanne
 *
 */
@Entity
@Table
public class Athlete {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	/** Constructeur
	 * 
	 */
	public Athlete() {
		super();
	}
	
	

	/** Constructeur
	 * @param id
	 * @param nom
	 * @param sexe
	 * @param taille
	 * @param poids
	 * @param age
	 */
	public Athlete(Integer id, String nom, Sexe sexe, Float taille, Float poids, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.sexe = sexe;
		this.taille = taille;
		this.poids = poids;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", taille=" + taille + ", poids=" + poids
				+ ", age=" + age + "]";
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

	/** Getter pour l'attribut sexe
	 * @return the sexe
	 */
	public Sexe getSexe() {
		return sexe;
	}

	/** Setter pour l'attribut sexe
	 * @param sexe the sexe to set
	 */
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	/** Getter pour l'attribut taille
	 * @return the taille
	 */
	public Float getTaille() {
		return taille;
	}

	/** Setter pour l'attribut taille
	 * @param taille the taille to set
	 */
	public void setTaille(Float taille) {
		this.taille = taille;
	}

	/** Getter pour l'attribut poids
	 * @return the poids
	 */
	public Float getPoids() {
		return poids;
	}

	/** Setter pour l'attribut poids
	 * @param poids the poids to set
	 */
	public void setPoids(Float poids) {
		this.poids = poids;
	}

	/** Getter pour l'attribut age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/** Setter pour l'attribut age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}



	
	
	
}
