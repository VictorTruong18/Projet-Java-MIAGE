package consignes;

import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Meuble;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionCommande extends Consigne {
	private Meuble meuble;

	public ReceptionCommande(int id, Meuble meuble) {
		super(id);
		this.meuble = meuble;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Consigne : Reception d'une commande  \n" + "Commande : " + this.meuble.getNom() + " piece de la Maison : " + 
		this.meuble.getPieceMaison() + " prix : " + this.meuble.getPrix() + " \nLots requis :\n" ;
		for(Lot lot : this.meuble.getLotsMeuble()) {
			s += "Nom : " +  lot.getNom() + " Volume : " + lot.getVolume() + "\n";
		}
		return s;
	}

	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		e.ajouterCommande(meuble);
		if(e.peutConstruire(meuble)) {
			for(Lot lots : meuble.getLotsMeuble()) {
				e.retirerLot(lots.getNom(),lots.getVolume());
			}
		} 
		
		
	}




	

}
