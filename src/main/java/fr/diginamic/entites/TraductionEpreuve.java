package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class TraductionEpreuve {

	@Id
	@Column(name ="CODE_LANGUE", length = 3)
	private String codeLangue;
	
	@Column(name="TRADUCTION_EPREUVE", length = 255)
	private String traductionEpreuve;
	
	/** Epreuve : plusieurs traductions pour une épreuve */
	@ManyToOne
	@JoinColumn(name="ID_EPREUVE")
	private Epreuve epreuve;

	/** Constructeur
	 * 
	 */
	public TraductionEpreuve() {
		super();
	}

	@Override
	public String toString() {
		return "TraductionEpreuve [codeLangue=" + codeLangue + ", traductionEpreuve=" + traductionEpreuve + ", epreuve="
				+ epreuve + "]";
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

	/** Getter pour l'attribut traductionEpreuve
	 * @return the traductionEpreuve
	 */
	public String getTraductionEpreuve() {
		return traductionEpreuve;
	}

	/** Setter pour l'attribut traductionEpreuve
	 * @param traductionEpreuve the traductionEpreuve to set
	 */
	public void setTraductionEpreuve(String traductionEpreuve) {
		this.traductionEpreuve = traductionEpreuve;
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
