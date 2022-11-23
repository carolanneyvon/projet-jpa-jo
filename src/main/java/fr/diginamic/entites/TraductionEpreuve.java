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
public class TraductionEpreuve {

	@Id
	@Column(name ="ID", length = 3)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codeLangue;
	
	@Column(name="TRADUCTION_EPREUVE", length = 255)
	private String traductionEpreuve;
	
	/** Epreuve : plusieurs traductions pour une épreuve */
	@ManyToOne
	@JoinColumn(name="ID_EPREUVE")
	private Epreuve epreuve;
}
