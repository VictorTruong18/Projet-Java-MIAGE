package appli;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	private Lot[] espacesRangee;
	
	public Rangee(int longueur) {
		this.longueur = longueur;
		espacesRangee = new Lot[longueur];
	}


	public void ajouterLot(Lot lot) {
		int espace = 0;
		for(int i = 0; i < espacesRangee.length; ++i) {
			if(espacesRangee[i] == null)
				++espace;
			if(espace >= lot.getVolume())
				for(int j = 0; j < i; ++j) {
					espacesRangee[j] = lot; 
					return;
				}
		}
	}
	
	public boolean estRempli() {
		//a faire
		return false;
	}
	
	public List<Integer> placeDisponible(Lot l) {
		if(estRempli())
			return null;
		int place = 0;
		List<Integer> indices = new ArrayList<>();
		
		for(int i = 0; i < espacesRangee.length; ++i) {
			if(espacesRangee[i] == null) {
				place++;
				if(place >= l.getVolume()) {
					indices.add(i - (l.getVolume() - 1));
				}
			}
			else
				place = 0;
		}
	
		return indices ;
	}
	
	@Override
	public String toString() {
		String c = "[ ";

		for(int i = 0; i < longueur; i++) {
			if(espacesRangee[i] == null )
				c += " x ;";
			else
			 c += " " + espacesRangee[i].getIdLot() + " ;";
		}

		c = c.substring(0, c.length() - 2);
		c += " ]";

		return c;
	}

	
	
}
