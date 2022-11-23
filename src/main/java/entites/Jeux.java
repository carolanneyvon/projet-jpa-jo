package entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Jeux {
	
	@Id
	private Integer id;
	
	@Column(name="ANNEE")
	private Date annee;
	
	@Column(name = "SAISON")
	@Enumerated(value = EnumType.STRING)
	private Saison saison;
	
	@Column(name="VILLE", length = 155)
	private String ville;

}
