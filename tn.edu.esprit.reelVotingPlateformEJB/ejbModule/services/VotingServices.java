package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Affectation;
import persistence.Choice;
import persistence.Party;
import persistence.Person;
import persistence.Question;

/**
 * Session Bean implementation class VotingServices
 */
@Stateless
public class VotingServices implements VotingServicesRemote,
		VotingServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public VotingServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean initDB() {
		boolean b = false;
		try {
			Person person = new Person("person1");
			Person person2 = new Person("person2");
			Person person3 = new Person("person3");

			Question question = new Question("question1");
			Question question2 = new Question("question2");
			Question question3 = new Question("question3");

			Choice choice = new Choice("the choice1");
			Choice choice2 = new Choice("the choice2");
			Choice choice3 = new Choice("the choice3");

			Party party = new Party("party1");
			Party party2 = new Party("party2");
			Party party3 = new Party("party3");

			entityManager.persist(person);
			entityManager.persist(person2);
			entityManager.persist(person3);

			entityManager.persist(question);
			entityManager.persist(question2);
			entityManager.persist(question3);

			entityManager.persist(party);
			entityManager.persist(party2);
			entityManager.persist(party3);

			entityManager.persist(choice);
			entityManager.persist(choice2);
			entityManager.persist(choice3);

			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}

	@Override
	public boolean assignChoiceToQuestion(int idQuestion, int idChoice) {
		boolean b = false;
		try {
			Question question = findQuestionById(idQuestion);
			Choice choice = findChoiceById(idChoice);

			choice.setQuestion(question);
			entityManager.merge(choice);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public Question findQuestionById(int idQuestion) {

		return entityManager.find(Question.class, idQuestion);
	}

	@Override
	public Choice findChoiceById(int idChoice) {
		return entityManager.find(Choice.class, idChoice);
	}

	@Override
	public boolean createAffectation(int idPerson, int idQuestion) {
		boolean b = false;
		try {
			Person person = findPersonById(idPerson);
			Question question = findQuestionById(idQuestion);

			Affectation affectation = new Affectation("new");
			affectation.setPerson(person);
			affectation.setQuestion(question);

			entityManager.persist(affectation);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public Person findPersonById(int idPerson) {
		return entityManager.find(Person.class, idPerson);
	}

	@Override
	public boolean makeChoice(int idPerson, int idQuestion, int idChoice) {
		boolean b = false;
		try {
			Person person = findPersonById(idPerson);
			Choice choice = findChoiceById(idChoice);
			Question question = findQuestionById(idQuestion);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

}
