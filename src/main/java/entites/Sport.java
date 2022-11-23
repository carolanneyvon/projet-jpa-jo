package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Sport {
	
	@Id
	private Integer id;
	
	@Column(name="NOM", length = 155)
	private String nom;
}
