package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Party
 *
 */
@Entity
@Table(name="T_PARTY")
public class Party implements Serializable {
@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idParty;
	private String nameParty;
	private static final long serialVersionUID = 1L;
	@ManyToMany(mappedBy="parties")
	private List<Choice> choices;

	public Party() {
		super();
	}   
	  
	public int getIdParty() {
		return this.idParty;
	}

	public void setIdParty(int idParty) {
		this.idParty = idParty;
	}   
	public String getNameParty() {
		return this.nameParty;
	}

	public void setNameParty(String nameParty) {
		this.nameParty = nameParty;
	}

	public Party(String nameParty) {
		super();
		this.nameParty = nameParty;
	}

}
