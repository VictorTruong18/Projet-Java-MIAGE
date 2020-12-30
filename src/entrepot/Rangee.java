package entrepot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import exceptions.InvalidAjoutLotRangeeException;

public class Rangee {
	private static int nbRangee = 0;
	private int id;
	private int longueur;
	private final int LARGEUR = 1, HAUTEUR = 1;
	
	private Lot[] espacesRangee;
	
	public Rangee(int longueur) {
		this.id = nbRangee;
		this.nbRangee++;
		this.longueur = longueur;
		espacesRangee = new Lot[longueur];
	}

	public boolean contienLot(String nom) {
		for(int i = 0 ; i <  longueur; i++) {
			
			if(espacesRangee[i] != null) {
				if(espacesRangee[i].getNom().equals(nom)){
					
					return true;
				}
			}
		
		}
		return false;
	}

	public void ajouterLot(Lot lot, int indice) {	
		try {
			List<Integer> places = placeDisponible(lot);
			if(places.contains(indice)) {
				int borneSuperieure = lot.getVolume() + places.get(0) - 1;
				for(int i = indice; i <= borneSuperieure; ++i)
					espacesRangee[i] = lot;
			} else {
				throw new InvalidAjoutLotRangeeException(this,indice);
			}
		} catch (InvalidAjoutLotRangeeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Lot retirerLot(Lot lot) {
		for(int i = 0; i < this.espacesRangee.length; i++) {
			if(this.espacesRangee[i].getIdLot() == lot.getIdLot()) {
				for(int j = 0; j < lot.getVolume(); j++) {
					this.espacesRangee[j] = null;
				}
				return lot;
			}
		}
		return null;
	}

	public void retirerLot(String nom, int volume) {
		for(int i = 0; i < this.espacesRangee.length; i++) {
			if(espacesRangee[i] != null) {
				System.out.println(espacesRangee[i].getNom());
				if(this.espacesRangee[i].getNom() == nom ) {
					for(int j = 0; j < volume; j++) {
						
						this.espacesRangee[j] = null;
					}

				}
			}
			
		}
	}

	
	public int getId() {
		return id;
	}


	public List<Integer> placeDisponible(Lot l) {
		
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
