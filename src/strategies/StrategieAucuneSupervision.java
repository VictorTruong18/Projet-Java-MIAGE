package strategies;

import java.util.ArrayList;
import java.util.List;

import consignes.Consigne;
import consignes.ReceptionCommande;
import consignes.ReceptionLot;
import consignes.Rien;
import entrepot.Entrepot;
import personnel.Ouvrier;
import personnel.Personnel;

//Accepter toutes les consignes
//Construire quand le materiel suffisant est present
public class StrategieAucuneSupervision implements Strategie {
	
	private Entrepot entrepot;
	
	/**
	 * @param entrepot
	 */
	public StrategieAucuneSupervision(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	/**
	 *
	 */
	@Override
	public void decisionConsigne(Consigne consigne) {
		List<Integer> PersonnelsLibres = new ArrayList<>();
		//Recherche des personnels libres et ajout dans la liste
		PersonnelsLibres = entrepot.getIndiceOuvrierLibre();
		System.out.println("\n" + consigne.toString() + "\n");
		//Selectionne le 1er ouvrier dispo
		Ouvrier PersonnelLibre = entrepot.getOuvrier(PersonnelsLibres.get(0));
		//L'ouvrier execute la consigne
		consigne.executionConsigne(PersonnelLibre, this.entrepot);
		
		
		
	}
	
	
	
}
