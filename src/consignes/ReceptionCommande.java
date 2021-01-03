package consignes;

import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Meuble;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionCommande extends Consigne {
	private Meuble meuble;

	/**
	 * @param id
	 * @param meuble
	 */
	public ReceptionCommande(int id, Meuble meuble) {
		super(id);
		this.meuble = meuble;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Consigne : Reception d'une commande  \n" + "Commande : " + this.meuble.getNom() + " piece de la Maison : " + 
		this.meuble.getPieceMaison() + " \nLots requis :\n" ;
		for(Lot lot : this.meuble.getLotsMeuble()) {
			s += "Nom : " +  lot.getNom() + " Volume : " + lot.getVolume() + "\n";
		}
		return s;
	}

	/**
	 * @param o : ouvrier ex�cutant la consigne
	 * @param e : l'entrepot ou est ex�cut� la consigne
	 * 
	 */
	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		//Ajoute une commande avec le meuble dans l'entrepot
		e.ajouterCommande(meuble);
		//Si les conditions n�cessaires pour construire le meuble :
		if(e.peutConstruire(meuble)) {
			//on retire les lots associ�s au meuble
			for(Lot lots : meuble.getLotsMeuble()) {
				e.retirerLot(lots.getNom(),lots.getVolume());
			}
			
		} 
		
		
	}	




	

}
