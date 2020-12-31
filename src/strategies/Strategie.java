package strategies;

import consignes.Consigne;

public interface Strategie {
	
	/**
	 * @param consigne
	 */
	public void decisionConsigne(Consigne consigne);
}
