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
	
	private Lot[] lotsRangee;
	
	public Rangee(int longueur) {
		this.longueur = longueur;
		lotsRangee = new Lot[longueur];
		System.out.println(lotsRangee);
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
	
	public boolean estRempli() {
		int volumes = 0;
		if(lotsRangee.length != 0)
			for(Lot l : lotsRangee)
				volumes += l.getVolume();
		return volumes < longueur;
	}
	
	public boolean placeDisponible(Lot l) {
		if(estRempli())
			return false;
		int volumes = 0;
		
		for(Lot lot : lotsRangee)
			volumes += l.getVolume();
		
		return (longueur - volumes) >= l.getVolume() ;
	}
	

	
	
}
