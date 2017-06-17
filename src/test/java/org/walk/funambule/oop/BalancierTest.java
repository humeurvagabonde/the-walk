package org.walk.funambule.oop;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BalancierTest {

	@Test
	public void testSucces() {
		Balancier balancier = new Balancier();
		balancier.sePoserGauche(4)
		         .sePoserDroite(3)
		         .sePoserGauche(2);
		
		assertEquals(Integer.valueOf(6), balancier.getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), balancier.getNbOiseauxDroite());
		assertFalse(balancier.getPerteEquilibre());
	}
}
