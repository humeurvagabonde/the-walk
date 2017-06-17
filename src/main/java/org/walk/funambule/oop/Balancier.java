package org.walk.funambule.oop;

public class Balancier {

	private Integer nbOiseauxGauche = 0;
	private Integer nbOiseauxDroite = 0;
	private Boolean perteEquilibre = false; 
	
	private final Integer limiteEquilibre = 3;
	
	// TODO : gerer le décollage negatif ou le nb d'oiseaux qui decollent > au nb d'oiseau du balancier
	
	public Balancier sePoserGauche(Integer nbOiseaux) {
		nbOiseauxGauche += nbOiseaux;
		isPerteEquilibre();
		return this;
	}
	
	public Balancier sePoserDroite(Integer nbOiseaux) {
		nbOiseauxDroite += nbOiseaux;
		isPerteEquilibre();
		return this;
	}
	
	private void isPerteEquilibre() {
		perteEquilibre = false;
	}

	private void setNbOiseauxGauche(Integer nbOiseauxGauche) {
		this.nbOiseauxGauche = nbOiseauxGauche;
	}

	private void setNbOiseauxDroite(Integer nbOiseauxDroite) {
		this.nbOiseauxDroite = nbOiseauxDroite;
	}

	public Integer getNbOiseauxGauche() {
		return nbOiseauxGauche;
	}

	public Integer getNbOiseauxDroite() {
		return nbOiseauxDroite;
	}

	public Boolean getPerteEquilibre() {
		return perteEquilibre;
	}
}
