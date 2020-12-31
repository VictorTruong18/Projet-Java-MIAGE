package consignes;

import java.util.List;

import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Rangee;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionLot extends Consigne {
	private Lot lot;
	
	/**
	 * @param id : l'id du lot
	 * @param lot : le lot
	 */
	public ReceptionLot(int id, Lot lot) {
		super(id);
		this.lot = lot;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		String s = "";
		s += "Consigne : Reception d'un lot  \n" + "Lot : " + this.lot.getNom() + " poids : " + 
		this.lot.getPoids() + " prix : " + this.lot.getPrix() + " volume : " + this.lot.getVolume();
		return s;
	}



	/**
	 * @param o : ouvrier exécutant la consigne
	 * @param e : l'entrepot ou est exécuté la consigne
	 */
	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		
		//Cherche une rangée disponible pour ranger le lot
		Rangee rangeeLibre = e.getRangeeLibre(this.lot);
		if(rangeeLibre == null) {
			System.out.println("Toutes les rangees sont occupees");
		} else {
			List<Integer> placeDisponible;
			//Trouve une place dispo dans cette rangée
			placeDisponible = rangeeLibre.placeDisponible(this.lot);
			//Selectionne la première place dispo
			int indiceEmplacement = placeDisponible.get(0);
			o.ajouterLot(rangeeLibre, this.lot, indiceEmplacement);
			e.ajouterLot(this.lot);
			System.out.println("Le lot a ete ajoute");
			
		}
			
		
		
	}
	
}
