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
		int volumes = 0;
		if(espacesRangee.length != 0)
			for(Lot l : espacesRangee)
				volumes += l.getVolume();
		return volumes < longueur;
	}
	
	public boolean placeDisponible(Lot l) {
		if(estRempli())
			return false;
		int volumes = 0;
		
		for(Lot lot : espacesRangee)
			volumes += l.getVolume();
		
		return (longueur - volumes) >= l.getVolume() ;
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
