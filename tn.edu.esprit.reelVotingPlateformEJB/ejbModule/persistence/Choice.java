package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Choice
 * 
 */
@Entity
@Table(name = "T_CHOICE")
public class Choice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChoice;
	private String theChoice;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "choice")
	private List<Affectation> affectations;
	@ManyToOne
	private Question question;
	@ManyToMany
	private List<Party> parties;

	public Choice() {
		super();
	}

	public int getIdChoice() {
		return this.idChoice;
	}

	public void setIdChoice(int idChoice) {
		this.idChoice = idChoice;
	}

	public String getTheChoice() {
		return this.theChoice;
	}

	public void setTheChoice(String theChoice) {
		this.theChoice = theChoice;
	}

	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public Choice(String theChoice) {
		super();
		this.theChoice = theChoice;
	}

	public void linkPartyToThisChoice(Party party) {
		parties.add(party);

	}
}
