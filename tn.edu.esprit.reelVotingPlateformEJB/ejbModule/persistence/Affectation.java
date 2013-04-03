package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Affectation
 * 
 */
@Entity
@Table(name = "T_AFFECTATION")
public class Affectation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAffectation;
	private String state;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Person person;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Choice choice;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Affectation() {
		super();
	}

	public int getIdAffectation() {
		return this.idAffectation;
	}

	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Affectation(String state) {
		super();
		this.state = state;
	}

}
