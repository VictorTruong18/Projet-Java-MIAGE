package appli;

import java.util.Map;

public class Rangee {
	
	private int longueur;
	private final int LARGEUR = 1, HAUTEUR = 1;
	
	private Lot[] lotsRangee;

	public void setLongueur(int longueur) {
		this.longueur = longueur;
		lotsRangee = new Lot[longueur];
	}
	
	public void ajouterLot(Lot lot) {
		int espace = 0;
		for(int i = 0; i < lotsRangee.length; ++i) {
			if(lotsRangee[i] == null)
				++espace;
			if(espace >= lot.getVolume())
				for(int j = 0; j < i; ++j) {
					lotsRangee[j] = lot; 
					return;
				}
		}
	}
	
	
	

}
