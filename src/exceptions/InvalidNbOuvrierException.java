package exceptions;

import personnel.ChefEquipe;
import personnel.Ouvrier;
import personnel.Personnel;

public class InvalidNbOuvrierException extends Exception {
	
	/**
	 * @param p : le personnel concern�
	 * @param NBMAX : le nombre maximum d'ouvrier possible
	 */
	public InvalidNbOuvrierException(Personnel p, int NBMAX) {
		super("Nombre maximum d'ouvriers atteint ( max : " + NBMAX + " )\n" +
		p.getPrenom() + " " + p.getNom() + " a atteint la limite");
	}
}
