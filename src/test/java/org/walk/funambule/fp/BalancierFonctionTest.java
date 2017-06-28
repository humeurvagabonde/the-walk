package org.walk.funambule.fp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.walk.funambule.fp.BalancierFonction.banane;
import static org.walk.funambule.fp.BalancierFonction.sePoserDroite;
import static org.walk.funambule.fp.BalancierFonction.sePoserDroiteAvecEquilibre;
import static org.walk.funambule.fp.BalancierFonction.sePoserGauche;
import static org.walk.funambule.fp.BalancierFonction.sePoserGaucheAvecEquilibre;

import java.util.Optional;

import org.junit.Test;

public class BalancierFonctionTest {

	@Test
	public void testAvecFonctions() {
		// gauche(4).droite(3).gauche(2)
		BalancierEtat balancier =  sePoserGauche.apply(2, sePoserDroite.apply(3, sePoserGauche.apply(4, new BalancierEtat())));
		assertEquals(Integer.valueOf(6), balancier.getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), balancier.getNbOiseauxDroite());
		
		
		balancier = sePoserGauche.andThen(b1 -> sePoserDroite.andThen(b2 -> sePoserGauche.apply(2, b2)).apply(3, b1)).apply(4, new BalancierEtat());
		assertEquals(Integer.valueOf(6), balancier.getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), balancier.getNbOiseauxDroite());
	}
	
	@Test
	public void testSuccesAvecFonctionsEtOptional() {
		// gauche(3).droite(3).gauche(2)
		Optional<BalancierEtat> etatOpt0 = sePoserGaucheAvecEquilibre.apply(3, new BalancierEtat());
		Optional<BalancierEtat> etatOpt1 = etatOpt0.flatMap(etat0 -> sePoserDroiteAvecEquilibre.apply(3, etat0));
		Optional<BalancierEtat> etatOpt2 = etatOpt1.flatMap(etat1 -> sePoserGaucheAvecEquilibre.apply(2, etat1));
		
		Optional<BalancierEtat> etatOptFinal = sePoserGaucheAvecEquilibre
				.apply(3, new BalancierEtat())
				.flatMap(etat0 -> sePoserDroiteAvecEquilibre.apply(3, etat0))
				.flatMap(etat1 -> sePoserGaucheAvecEquilibre.apply(2, etat1));
		
		assertEquals(Integer.valueOf(5), etatOptFinal.get().getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), etatOptFinal.get().getNbOiseauxDroite());
	}
	
	@Test
	public void testEchecDesequilibreAvecFonctionsEtOptional() {
		// gauche(3).droite(3).droite(-1).gauche(3)
		Optional<BalancierEtat> etatOptFinal = sePoserGaucheAvecEquilibre
				.apply(3, new BalancierEtat())
				.flatMap(etat0 -> sePoserDroiteAvecEquilibre.apply(3, etat0))
				.flatMap(etat1 -> sePoserDroiteAvecEquilibre.apply(-1, etat1))
				.flatMap(etat2 -> sePoserGaucheAvecEquilibre.apply(3, etat2));
		
		assertFalse(etatOptFinal.isPresent());
	}
	
	@Test
	public void testEchecBananeAvecFonctionsEtOptional() {
		// gauche(3).droite(3).droite(2).banane().gauche(2)
		Optional<BalancierEtat> etatOptFinal = sePoserGaucheAvecEquilibre
				.apply(3, new BalancierEtat())
				.flatMap(etat0 -> sePoserDroiteAvecEquilibre.apply(3, etat0))
				.flatMap(etat1 -> sePoserDroiteAvecEquilibre.apply(2, etat1))
				.flatMap(banane)
				.flatMap(etat2 -> sePoserGaucheAvecEquilibre.apply(2, etat2));
		
		assertFalse(etatOptFinal.isPresent());
	}

}
