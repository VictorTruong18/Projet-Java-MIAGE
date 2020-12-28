package personnel;

import entrepot.Lot;
import entrepot.Rangee;

public class Ouvrier extends Personnel {
	
	
	private static final int SALAIRE = 5;
	private ChefEquipe chefEquipe = null;
	private PieceDelaMaison specialite = null;

	public Ouvrier(String nom, String prenom,ChefEquipe chefEquipe,PieceDelaMaison specialite) {
		super(nom, prenom, SALAIRE);
		this.chefEquipe = chefEquipe;
		this.specialite = specialite;
	}
	
	public Ouvrier(String nom, String prenom, int s) {
		super(nom,prenom,s);
	}
	

	public PieceDelaMaison getSpecialite() {
		return specialite;
	}

	public ChefEquipe getChefEquipe() {
		return chefEquipe;
	}

	public int getSALAIRE() {
		return SALAIRE;
	}
	
	
	public void ajouterLot(Rangee rangee, Lot lot, int indice) {
		rangee.ajouterLot(lot, indice);
	}
	
	public Lot retirerLot(Rangee rangee, Lot lot) {
		return rangee.retirerLot(lot);
	}
	
	
	
	

}

