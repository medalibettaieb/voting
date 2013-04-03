package junitTests;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.VotingServicesRemote;

public class TestReelPlateforme {
	private Context context;
	private VotingServicesRemote proxy;

	@Before
	public void setUp() throws Exception {
		context = new InitialContext();
		proxy = (VotingServicesRemote) context
				.lookup("ejb:tn.edu.esprit.reelVotingPlateform/tn.edu.esprit.reelVotingPlateformEJB/VotingServices!services.VotingServicesRemote");
	}

	@Test
	public void testInitDB() {
		Assert.assertTrue(proxy.initDB());
	}

	@Test
	public void testAssignListChoiceToQuestion() {
		Assert.assertTrue(proxy.assignChoiceToQuestion(4, 10));
		Assert.assertTrue(proxy.assignChoiceToQuestion(4, 11));
		Assert.assertTrue(proxy.assignChoiceToQuestion(4, 12));
	}

	@Test
	public void testCreateAffectation() {
		Assert.assertTrue(proxy.createAffectation(1, 4));
		Assert.assertTrue(proxy.createAffectation(1, 5));
		Assert.assertTrue(proxy.createAffectation(1, 6));
	}

	@Test
	public void testMakeChoice() {
		Assert.assertTrue(proxy.makeChoice(1, 4, 11));
	}

	@Test
	public void testLinkChoiceToParty() {
		Assert.assertTrue(proxy.linkChoiceToParty(11, 7));
		Assert.assertTrue(proxy.linkChoiceToParty(11, 8));
	}

	@Test
	public void testFindListOfPartiesByChoice() {
		Assert.assertEquals(2, proxy.findListOfPartiesByChoice(10).size());
	}

}
