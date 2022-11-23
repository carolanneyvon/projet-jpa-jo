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
public class TraductionBanniere {

	@Id
	@Column(name ="ID", length = 3)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codeLangue;
	
	@Column(name="TRADUCTION_BANNIERE", length = 255)
	private String traductionBanniere;
	
	/** Banniere : plusieurs traductions pour une bannière */
	@ManyToOne
	@JoinColumn(name="ID_BANNIERE")
	private Banniere banniere;
}
