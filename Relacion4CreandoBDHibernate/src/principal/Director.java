package principal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Director")
@SuppressWarnings("serial")
public class Director implements Serializable {

	@Id
	@Column(name="ID_DIRECTOR")
	private int id;
	@OneToMany()
	
}
