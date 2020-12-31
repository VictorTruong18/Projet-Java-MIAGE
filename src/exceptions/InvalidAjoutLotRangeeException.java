package exceptions;

import entrepot.Rangee;
import personnel.Personnel;

public class InvalidAjoutLotRangeeException extends Exception{
	
	/**
	 * @param rangee : la rang�e concern�e
	 * @param indice : l'indice ou le lot � tent� d'�tre ajout�e
	 */
	public InvalidAjoutLotRangeeException(Rangee rangee, int indice) {
		super("Impossible d'ajouter l'objet a l'indice " + 
				 indice + " sur la rangee a d'id : " + rangee.getId());
	}
}
