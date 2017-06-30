package org.walk.funambule.fp;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 
 * Module gestion balancier.
 * 
 * On ne gere pas le cas ou le nombre d'oiseaux devient négatif.
 */
public class BalancierFonction {

	/*
	 * FONCTIONS QUI NE PEUVENT PAS "ECHOUER"
	 */
	/**
	 * Integer -> BalancierEtat -> BalancierEtat
	 */
	public static BiFunction<Integer, BalancierEtat, BalancierEtat> sePoserGauche =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				return new BalancierEtat(balancier.getNbOiseauxGauche() + nbOiseaux, balancier.getNbOiseauxDroite());
			};
	
	/**
	 * Integer -> BalancierEtat -> BalancierEtat
	 */
	public static BiFunction<Integer, BalancierEtat, BalancierEtat> sePoserDroite =
			(nbOiseaux, balancier) -> new BalancierEtat(balancier.getNbOiseauxGauche(), balancier.getNbOiseauxDroite() + nbOiseaux);

			
	/*
	 * FONCTIONS QUI PEUVENT "ECHOUER"
	 */
	/**
	 * Integer -> BalancierEtat -> Optional<BalancierEtat>
	 */
	public static BiFunction<Integer, BalancierEtat, Optional<BalancierEtat>> sePoserGaucheAvecEquilibre =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				Boolean isBalancierEnEquilibre = Math.abs((balancier.getNbOiseauxGauche() + nbOiseaux) - balancier.getNbOiseauxDroite()) < 4;
				if (!isBalancierEnEquilibre) {
					return Optional.empty();
				}
				return Optional.of(new BalancierEtat(balancier.getNbOiseauxGauche() + nbOiseaux, balancier.getNbOiseauxDroite()));
			};

	/**
	 * Integer -> BalancierEtat -> Optional<BalancierEtat>
	 */
	public static BiFunction<Integer, BalancierEtat, Optional<BalancierEtat>> sePoserDroiteAvecEquilibre =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				Boolean isBalancierEnEquilibre = Math.abs(balancier.getNbOiseauxGauche() - (balancier.getNbOiseauxDroite() + nbOiseaux)) < 4;
				if (!isBalancierEnEquilibre) {
					return Optional.empty();
				}
				return Optional.of(new BalancierEtat(balancier.getNbOiseauxGauche(), balancier.getNbOiseauxDroite() + nbOiseaux));
			};
			
	/**
	 * BalancierEtat -> Optional<BalancierEtat>
	 */
	public static Function<BalancierEtat, Optional<BalancierEtat>> banane =
			(BalancierEtat b) -> Optional.empty(); 
			
}
