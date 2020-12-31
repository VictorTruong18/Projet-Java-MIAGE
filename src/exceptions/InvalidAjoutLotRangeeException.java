package exceptions;

import entrepot.Rangee;
import personnel.Personnel;

public class InvalidAjoutLotRangeeException extends Exception{
	
	/**
	 * @param rangee : la rangée concernée
	 * @param indice : l'indice ou le lot à tenté d'être ajoutée
	 */
	public InvalidAjoutLotRangeeException(Rangee rangee, int indice) {
		super("Impossible d'ajouter l'objet a l'indice " + 
				 indice + " sur la rangee a d'id : " + rangee.getId());
	}
}
