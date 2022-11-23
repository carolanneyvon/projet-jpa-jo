package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
