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
public class TraductionBanniere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="CODE_LANGUE", length = 3)
	private String codeLangue;
	
	@Column(name="TRADUCTION_BANNIERE", length = 255)
	private String traductionBanniere;
	
	/** Banniere : plusieurs traductions pour une bannière */
	@ManyToOne
	@JoinColumn(name="ID_BANNIERE")
	private Banniere banniere;

	/** Constructeur
	 * 
	 */
	public TraductionBanniere() {
		super();
	}

	/** Constructeur
	 * @param codeLangue
	 * @param traductionBanniere
	 * @param banniere
	 */
	public TraductionBanniere(String codeLangue, String traductionBanniere, Banniere banniere) {
		super();
		this.codeLangue = codeLangue;
		this.traductionBanniere = traductionBanniere;
		this.banniere = banniere;
	}



	@Override
	public String toString() {
		return "TraductionBanniere [codeLangue=" + codeLangue + ", traductionBanniere=" + traductionBanniere
				+ ", banniere=" + banniere + "]";
	}

	/** Getter pour l'attribut codeLangue
	 * @return the codeLangue
	 */
	public String getCodeLangue() {
		return codeLangue;
	}

	/** Setter pour l'attribut codeLangue
	 * @param codeLangue the codeLangue to set
	 */
	public void setCodeLangue(String codeLangue) {
		this.codeLangue = codeLangue;
	}

	/** Getter pour l'attribut traductionBanniere
	 * @return the traductionBanniere
	 */
	public String getTraductionBanniere() {
		return traductionBanniere;
	}

	/** Setter pour l'attribut traductionBanniere
	 * @param traductionBanniere the traductionBanniere to set
	 */
	public void setTraductionBanniere(String traductionBanniere) {
		this.traductionBanniere = traductionBanniere;
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
	
	
}
