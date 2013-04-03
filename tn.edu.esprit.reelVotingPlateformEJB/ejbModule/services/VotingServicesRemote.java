package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Choice;
import persistence.Party;
import persistence.Person;
import persistence.Question;

@Remote
public interface VotingServicesRemote {

	boolean initDB();

	boolean assignChoiceToQuestion(int idQuestion, int idChoice);

	Question findQuestionById(int idQuestion);

	Choice findChoiceById(int idChoice);

	Person findPersonById(int idPerson);

	Party findPartyById(int idParty);

	boolean createAffectation(int idPerson, int idQuestion);

	boolean makeChoice(int idPerson, int idQuestion, int idChoice);

	boolean linkChoiceToParty(int idChoice, int idParty);

	List<Party> findListOfPartiesByChoice(int idChoice);

}
