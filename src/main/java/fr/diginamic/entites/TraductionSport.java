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
public class TraductionSport {

	@Id
	@Column(name ="CODE_LANGUE", length = 3)
	private String codeLangue;
	
	@Column(name="TRADUCTION_SPORT", length = 255)
	private String traductionSport;
	
	/** Sport : plusieurs traductions pour un sport */
	@ManyToOne
	@JoinColumn(name="ID_SPORT")
	private Sport sport;

	/** Constructeur
	 * 
	 */
	public TraductionSport() {
		super();
	}

	@Override
	public String toString() {
		return "TraductionSport [codeLangue=" + codeLangue + ", traductionSport=" + traductionSport + ", sport=" + sport
				+ "]";
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

	/** Getter pour l'attribut traductionSport
	 * @return the traductionSport
	 */
	public String getTraductionSport() {
		return traductionSport;
	}

	/** Setter pour l'attribut traductionSport
	 * @param traductionSport the traductionSport to set
	 */
	public void setTraductionSport(String traductionSport) {
		this.traductionSport = traductionSport;
	}

	/** Getter pour l'attribut sport
	 * @return the sport
	 */
	public Sport getSport() {
		return sport;
	}

	/** Setter pour l'attribut sport
	 * @param sport the sport to set
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
}
