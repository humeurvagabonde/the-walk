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

	/*
	 * FONCTIONS QUI NE PEUVENT PAS "ECHOUER"
	 */
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
	
	/*
	 * FONCTIONS QUI PEUVENT "ECHOUER"
	 */
	@Test
	public void testCompositionAvecFonctionsEtOptional() {
		// gauche(4).droite(3).gauche(2)
		//BalancierEtat balancier =  sePoserGaucheAvecEquilibre.apply(2, sePoserDroiteAvecEquilibre.apply(3, sePoserGaucheAvecEquilibre.apply(4, new BalancierEtat())));
		
		/*
		 * En introduisant le Optional on ne peut plus composer nos fonctions.
		 * sePoserGaucheAvecEquilibre :: Integer -> BalancierEtat -> Optional<BalancierEtat>
		 * sePoserDroiteAvecEquilibre :: Integer -> BalancierEtat -> Optional<BalancierEtat>
		 */
	}
	
	@Test
	public void testSuccesAvecFonctionsEtOptionalEtDoliprane() {
		// gauche(3).droite(3).gauche(2)
		Optional<BalancierEtat> etatOptFinal = Optional.empty();
		Optional<BalancierEtat> etatOpt0 = sePoserGaucheAvecEquilibre.apply(3, new BalancierEtat());
		if (etatOpt0.isPresent()) {
			Optional<BalancierEtat> etatOpt1 = etatOpt0.flatMap(etat0 -> sePoserDroiteAvecEquilibre.apply(3, etat0));
			if (etatOpt1.isPresent()) {
				Optional<BalancierEtat> etatOpt2 = etatOpt1.flatMap(etat1 -> sePoserGaucheAvecEquilibre.apply(2, etat1));
				if (etatOpt2.isPresent()) {
					etatOptFinal = etatOpt2;
				}
			}
		}
		assertEquals(Integer.valueOf(5), etatOptFinal.get().getNbOiseauxGauche());
		assertEquals(Integer.valueOf(3), etatOptFinal.get().getNbOiseauxDroite());
	}
	
	@Test
	public void testSuccesAvecFonctionsEtOptional() {
		// gauche(3).droite(3).gauche(2)
		// Le map/flatMap encapsule la vérification du isPresent
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
	
	@Test
	public void testEchecNombreNegatifInvalideAvecFonctionsEtOptional() {
		// gauche(3).gauche(-10)
		Optional<BalancierEtat> etatOptFinal = sePoserGaucheAvecEquilibre
				.apply(3, new BalancierEtat())
				.flatMap(etat1 -> sePoserGaucheAvecEquilibre.apply(-10, etat1));
		
		assertFalse(etatOptFinal.isPresent());
	}

}
