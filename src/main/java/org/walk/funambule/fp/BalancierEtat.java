package org.walk.funambule.fp;

/**
 * 
 * Classe Immutable.
 *
 */
public class BalancierEtat {

	private Integer nbOiseauxGauche;
	private Integer nbOiseauxDroite;
	
	public BalancierEtat() {
		this(0, 0);
	}
	
	public BalancierEtat(Integer nbOiseauxGauche, Integer nbOiseauxDroite) {
		this.nbOiseauxGauche = nbOiseauxGauche;
		this.nbOiseauxDroite = nbOiseauxDroite;
	}

	public Integer getNbOiseauxGauche() {
		return nbOiseauxGauche;
	}

	public Integer getNbOiseauxDroite() {
		return nbOiseauxDroite;
	}

	
	@Override
	public String toString() {
		return "BalancierEtat [nbOiseauxGauche=" + nbOiseauxGauche + ", nbOiseauxDroite=" + nbOiseauxDroite + "]";
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
		BalancierEtat other = (BalancierEtat) obj;
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
