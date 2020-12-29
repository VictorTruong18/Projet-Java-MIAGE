package consignes;

import java.util.List;

import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Rangee;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionLot extends Consigne {
	private Lot lot;
	
	public ReceptionLot(int id, Lot lot) {
		super(id);
		this.lot = lot;
	}
	
	public String toString() {
		String s = "";
		s += "Consigne : Reception d'un lot  \n" + "Lot : " + this.lot.getNom() + " poids : " + 
		this.lot.getPoids() + " prix : " + this.lot.getPrix() + " volume : " + this.lot.getVolume();
		return s;
	}



	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		
		Rangee rangeeLibre = e.getRangeeLibre(this.lot);
		if(rangeeLibre == null) {
			System.out.println("Toutes les rangees sont occupees");
		} else {
			List<Integer> placeDisponible;
			placeDisponible = rangeeLibre.placeDisponible(this.lot);
			int indiceEmplacement = placeDisponible.get(0);
			o.ajouterLot(rangeeLibre, this.lot, indiceEmplacement);
			System.out.println("Le lot a ete ajoute");
			
		}
			
		
		
	}
	
}
