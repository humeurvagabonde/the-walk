package org.walk.funambule.oop;

/**
 * 
 * On ne gere pas le cas ou le nombre d'oiseaux devient négatif.
 */
public class Balancier {

    private static final Integer LIMITE_PERTE_BALANCE = 4;
    
	private Integer nbOiseauxGauche = 0;
	private Integer nbOiseauxDroite = 0;
	
	/**
	 * IMPLEMENTATION DIFFERENTE 
	 * Si on considere que la perte d'equilibre est un Etat possible
	 * Alors on peut imaginer gerer un flag perteEquilibre plutot qu'une exception 
	 */
	/*
    private Boolean perteEquilibre = false; 
	private void isPerteEquilibre() {
		perteEquilibre = false;
	}
	*/
	
	public Balancier sePoserGauche(Integer nbOiseaux) {
		Boolean isBalancierEnEquilibre = Math.abs((nbOiseauxGauche + nbOiseaux) - nbOiseauxDroite) < LIMITE_PERTE_BALANCE;
		if (!isBalancierEnEquilibre) {
			throw new IllegalArgumentException("Ouh ! C'est la chute. J'ai la gauche plus lourde que la droite");
		}
		nbOiseauxGauche += nbOiseaux;
		return this;
	}
	
	public Balancier sePoserDroite(Integer nbOiseaux) {
		Boolean isBalancierEnEquilibre = Math.abs(nbOiseauxGauche - (nbOiseauxDroite + nbOiseaux)) < LIMITE_PERTE_BALANCE;
		if (!isBalancierEnEquilibre) {
			throw new IllegalArgumentException("Ouh ! C'est la chute. J'ai la droite plus lourde que la gauche");
		}
		nbOiseauxDroite += nbOiseaux;
		return this;
	}
	
	public Integer getNbOiseauxGauche() {
		return nbOiseauxGauche;
	}

	public Integer getNbOiseauxDroite() {
		return nbOiseauxDroite;
	}
	
	@Override
	public String toString() {
		return "Balancier [nbOiseauxGauche=" + nbOiseauxGauche + ", nbOiseauxDroite=" + nbOiseauxDroite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nbOiseauxDroite == null) ? 0 : nbOiseauxDroite.hashCode());
		result = prime * result + ((nbOiseauxGauche == null) ? 0 : nbOiseauxGauche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balancier other = (Balancier) obj;
		if (nbOiseauxDroite == null) {
			if (other.nbOiseauxDroite != null)
				return false;
		} else if (!nbOiseauxDroite.equals(other.nbOiseauxDroite))
			return false;
		if (nbOiseauxGauche == null) {
			if (other.nbOiseauxGauche != null)
				return false;
		} else if (!nbOiseauxGauche.equals(other.nbOiseauxGauche))
			return false;
		return true;
	}
}
