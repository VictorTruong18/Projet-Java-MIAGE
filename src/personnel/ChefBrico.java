package personnel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import exceptions.InvalidNbOuvrierException;

public class ChefBrico extends ChefEquipe{
	private static final int SALAIRE = 10;
	private static final int MAX_OUVRIER = 4;
	
	
	
	/**
	 * @param nom : nom du chef
	 * @param prenom : prenom du chef
	 */
	public ChefBrico( String nom, String prenom) {
		super(nom, prenom, SALAIRE, MAX_OUVRIER);
		
		// TODO Auto-generated constructor stub
	}

	


}