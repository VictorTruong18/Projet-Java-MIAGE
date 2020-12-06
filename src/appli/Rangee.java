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
	
	private Map<Lot,Integer> lotsRangee;

	public void setLongueur(int longueur) {
		this.longueur = longueur;
		lotsRangee = new HashMap<>();
	}
	
	
	public void ajouterLot(Lot lot) {
		if(!estRempli())
			lotsRangee.put(lot, lot.getVolume());
	}
	
	public boolean estRempli() {
		int volumes = 0;
		if(!lotsRangee.isEmpty())
			for(Entry e : lotsRangee.entrySet())
				volumes += (int) e.getValue();
		return volumes < longueur;
	}
	
	
	

}
