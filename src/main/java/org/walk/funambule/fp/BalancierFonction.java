package org.walk.funambule.fp;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.walk.funambule.oop.Balancier;

public class BalancierFonction {

	// TODO 
	// p.e faire une troisieme version ou on remet Etat + Fonctions dans la meme classe 
	// et ou on gere en interne des Optional
	
	public static BiFunction<Integer, BalancierEtat, BalancierEtat> sePoserGauche =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				return new BalancierEtat(balancier.getNbOiseauxGauche() + nbOiseaux, balancier.getNbOiseauxDroite());
			};
	
	public static BiFunction<Integer, BalancierEtat, BalancierEtat> sePoserDroite =
			(nbOiseaux, balancier) -> 
				new BalancierEtat(balancier.getNbOiseauxGauche(), balancier.getNbOiseauxDroite() + nbOiseaux);

	public static BiFunction<Integer, BalancierEtat, Optional<BalancierEtat>> sePoserGaucheAvecEquilibre =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				Boolean isBalancierEnEquilibre = Math.abs((balancier.getNbOiseauxGauche() + nbOiseaux) - balancier.getNbOiseauxDroite()) < 4;
				if (!isBalancierEnEquilibre) {
					return Optional.empty();
				}
				return Optional.of(new BalancierEtat(balancier.getNbOiseauxGauche() + nbOiseaux, balancier.getNbOiseauxDroite()));
			};

	
	public static BiFunction<Integer, BalancierEtat, Optional<BalancierEtat>> sePoserDroiteAvecEquilibre =
			(Integer nbOiseaux, BalancierEtat balancier) -> {
				Boolean isBalancierEnEquilibre = Math.abs(balancier.getNbOiseauxGauche() - (balancier.getNbOiseauxDroite() + nbOiseaux)) < 4;
				if (!isBalancierEnEquilibre) {
					return Optional.empty();
				}
				return Optional.of(new BalancierEtat(balancier.getNbOiseauxGauche(), balancier.getNbOiseauxDroite() + nbOiseaux));
			};
			
	public static Function<BalancierEtat, Optional<BalancierEtat>> banane =
			(BalancierEtat b) -> Optional.empty(); 
			
}
