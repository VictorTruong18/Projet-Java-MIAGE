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
	
	/**
	 * @param longueur
	 */
	public Rangee(int longueur) {
		this.id = nbRangee;
		this.nbRangee++;
		this.longueur = longueur;
		espacesRangee = new Lot[longueur];
	}

	/**
	 * @param nom
	 * @return si le lot est dans la rang�e
	 */
	public boolean contienLot(String nom) {
		for(int i = 0 ; i <  longueur; i++) {
			
			//Si la case n'est pas vide
			if(espacesRangee[i] != null) {
				//On v�rifie que le lot correspond au type de lot recherch�
				if(espacesRangee[i].getNom().equals(nom)){
					
					return true;
				}
			}
		
		}
		return false;
	}

	/**
	 * @param lot : le lot � ajouter
	 * @param indice : indice dans la rang�e
	 */
	public void ajouterLot(Lot lot, int indice) {	
		try {
			List<Integer> places = placeDisponible(lot);
			//Si l'indice donn� est bien disponible
			if(places.contains(indice)) {
				//Borne sup�rieure de la place
				int borneSuperieure = lot.getVolume() + places.get(0) - 1;
				for(int i = indice; i <= borneSuperieure; ++i)
					//On r�f�rence l'objet dans chaque case de l'intervalle de la place
					espacesRangee[i] = lot;
			} else {
				//Si l'indice donn� n'est pas valide, on renvoie une exception
				throw new InvalidAjoutLotRangeeException(this,indice);
			}
		} catch (InvalidAjoutLotRangeeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * @param lot : le lot � retirer
	 * @return le lot retir�
	 */
	public Lot retirerLot(Lot lot) {
		for(int i = 0; i < this.espacesRangee.length; i++) {
			//Le lot � retirer est trouv�
			if(this.espacesRangee[i].getIdLot() == lot.getIdLot()) {
				
				for(int j = 0; j < lot.getVolume(); j++) {
					//Pour chaque case ou le lot est contenu, on d�r�ference le lot
					this.espacesRangee[j] = null;
				}
				return lot;
			}
		}
		return null;
	}

	/**
	 * @param nom
	 * @param volume
	 */
	public void retirerLot(String nom, int volume) {
		for(int i = 0; i < this.espacesRangee.length; i++) {
			//Si la case esgt vide
			if(espacesRangee[i] != null) {
				
				System.out.println(espacesRangee[i].getNom());
				//Si le nom correspond au nom du lot � retirer
				if(this.espacesRangee[i].getNom() == nom ) {
					for(int j = 0; j < volume; j++) {
						//On vide toutes les cases occup�es par ce lot (d�r�f�rencement de l'objet)
						this.espacesRangee[j] = null;
					}

				}
			}
			
		}
	}

	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param l : le lot utilis� pour v�rifier son bon rangement
	 * @return la liste de place dispo pour ajouter le lot
	 */
	public List<Integer> placeDisponible(Lot l) {
		
		int place = 0;
		List<Integer> indices = new ArrayList<>();
		
		for(int i = 0; i < espacesRangee.length; ++i) {
			//Si la case est vide
			if(espacesRangee[i] == null) {
				//On augmente le nombre de case dispo
				place++;
				//Si le nombre de case dispo correspond au volume
				if(place >= l.getVolume()) {
					//On ajoute l'indice de d�part de l'espace associ�
					indices.add(i - (l.getVolume() - 1));
				}
			}
			//Si la case est occup�e, on remet � 0 la taille de l'espace
			else
				place = 0;
		}
	
		return indices ;
	}
	
	/**
	 *
	 */
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
