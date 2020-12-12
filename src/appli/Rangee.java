package appli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Rangee {
	
	private int longueur;
	private final int LARGEUR = 1, HAUTEUR = 1;
	
	private List<Lot> lotsRangee;
	
	public Rangee(int longueur) {
		this.longueur = longueur;
		lotsRangee = new ArrayList<Lot>(longueur);
		System.out.println(lotsRangee);
	}


	
	public void ajouterLot(Lot lot) {
		lotsRangee.add(lot);
	}
	
	public boolean estRempli() {
		int volumes = 0;
		if(!lotsRangee.isEmpty())
			for(Lot l : lotsRangee)
				volumes += l.getVolume();
		return volumes < longueur;
	}
	
	public boolean placeDisponible(Lot l) {
		Iterator it = this.lotsRangee.iterator();
		int counter = 0;
		while(it.hasNext()) {
			if(it.next() == null) {
				counter++;
				if(counter == l.getVolume()) {
					return true;
				}
			} else {
				counter=0;
			}
		}
		return false;
	}
	

	
	
}
