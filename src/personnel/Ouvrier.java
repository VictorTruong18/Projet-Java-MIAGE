package personnel;

import entrepot.Lot;
import entrepot.Rangee;

public class Ouvrier extends Personnel {
	
	
	private static final int SALAIRE = 5;
	private ChefEquipe chefEquipe = null;
	private PieceDelaMaison specialite = null;

	/**
	 * @param nom
	 * @param prenom
	 * @param chefEquipe
	 * @param specialite
	 */
	public Ouvrier(String nom, String prenom,ChefEquipe chefEquipe,PieceDelaMaison specialite) {
		super(nom, prenom, SALAIRE);
		this.chefEquipe = chefEquipe;
		this.specialite = specialite;
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param s
	 */
	public Ouvrier(String nom, String prenom, int s) {
		super(nom,prenom,s);
	}
	

	/**
	 * @return
	 */
	public PieceDelaMaison getSpecialite() {
		return specialite;
	}

	/**
	 * @return
	 */
	public ChefEquipe getChefEquipe() {
		return chefEquipe;
	}

	/**
	 *
	 */
	public int getSALAIRE() {
		return SALAIRE;
	}
	
	
	/**
	 * @param rangee
	 * @param lot
	 * @param indice
	 */
	public void ajouterLot(Rangee rangee, Lot lot, int indice) {
		rangee.ajouterLot(lot, indice);
	}
	
	/**
	 * @param rangee
	 * @param lot
	 * @return
	 */
	public Lot retirerLot(Rangee rangee, Lot lot) {
		return rangee.retirerLot(lot);
	}
	
	
	
	

}

