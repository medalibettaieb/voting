package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Question
 * 
 */
@Entity
@Table(name = "T_QUESTION")
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idQuestion;
	private String theQuestion;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "question")
	private List<Affectation> affectations;
	@OneToMany(mappedBy = "question")
	private List<Choice> choices;

	public Question() {
		super();
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getTheQuestion() {
		return this.theQuestion;
	}

	public void setTheQuestion(String theQuestion) {
		this.theQuestion = theQuestion;
	}

	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public Question(String theQuestion) {
		super();
		this.theQuestion = theQuestion;
	}

}
