package appli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Rangee {
	
	private int longueur;
	private final int LARGEUR = 1, HAUTEUR = 1;
	
	private List<Lot> lotsRangee;

	public void setLongueur(int longueur) {
		this.longueur = longueur;
		lotsRangee = new LinkedList<>();
	}
	
	public void ajouterLot(Lot lot) {
		if(!estRempli())
			lotsRangee.add(lot);
	}
	
	public boolean estRempli() {
		int volumes = 0;
		if(!lotsRangee.isEmpty())
			for(Lot l : lotsRangee)
				volumes += l.getVolume();
		return volumes < longueur;
	}
	
	
}
