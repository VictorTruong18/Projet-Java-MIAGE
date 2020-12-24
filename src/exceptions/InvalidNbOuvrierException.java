package exceptions;

import personnel.ChefEquipe;
import personnel.Ouvrier;
import personnel.Personnel;

public class InvalidNbOuvrierException extends Exception {
	
	public InvalidNbOuvrierException(Personnel p, int NBMAX) {
		super("Nombre maximum d'ouvriers atteint ( max : " + NBMAX + " )\n" +
		p.getPrenom() + " " + p.getNom() + " a atteint la limite");
	}
}
