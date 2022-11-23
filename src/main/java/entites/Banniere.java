package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Banniere {
	
	@Id
	private Integer id;
	
	@Column(name="CIOCODE", length = 3)
	private String cioCode;
	
	@Column(name="NOM", length = 155)
	private String nom;
	
	@Column(name="STATUT")
	private Boolean statut;

}
