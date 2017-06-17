package org.walk.funambule.fp;

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
}
