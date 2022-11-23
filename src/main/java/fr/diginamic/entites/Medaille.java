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

import fr.diginamic.enumeration.Couleur;

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
}
