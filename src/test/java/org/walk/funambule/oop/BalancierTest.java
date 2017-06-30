package org.walk.funambule.oop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancierTest {

	@Test(expected = IllegalArgumentException.class)
	public void testErreur() {
		Balancier balancier = new Balancier();
		balancier.sePoserGauche(1)
				 .sePoserDroite(4)
				 .sePoserGauche(-1)
				 .sePoserDroite(-2);
		
		// Et pourtant au final la difference n'est que de deux.
		// assertEquals(Integer.valueOf(0), balancier.getNbOiseauxGauche());
		// assertEquals(Integer.valueOf(2), balancier.getNbOiseauxDroite());
	}
	
	@Test
	public void testGestionErreurPasPratique() {
		Balancier balancier = new Balancier();
		try {
			balancier.sePoserGauche(1)
					 .sePoserDroite(4)
					 .sePoserGauche(-1)
					 .sePoserDroite(-2);
		} catch (IllegalArgumentException iae) {
			assertEquals(Integer.valueOf(1), balancier.getNbOiseauxGauche());
			assertEquals(Integer.valueOf(4), balancier.getNbOiseauxDroite());
			
			// continuer le traitement suite a une exception n'est pas tres pratique.
		}
	}
	
	@Test
	public void testSucces() {
		Balancier balancier = new Balancier();
		balancier.sePoserGauche(3)
        		 .sePoserDroite(3)
        		 .sePoserGauche(2);
		
		assertEquals(Integer.valueOf(5), balancier.getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), balancier.getNbOiseauxDroite());
	}
}
