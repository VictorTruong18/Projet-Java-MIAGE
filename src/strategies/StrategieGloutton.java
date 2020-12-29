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

//Recuperer les objets qui ont le prix le plus eleve
//Construire des que possible 
public class StrategieGloutton implements Strategie {
	
	private Entrepot entrepot;
	
	public StrategieGloutton(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	@Override
	public void decisionConsigne(Consigne consigne) {
		List<Integer> PersonnelsLibres = new ArrayList<>();
		PersonnelsLibres = entrepot.getIndiceOuvrierLibre();
		
		if(consigne instanceof Rien) {
			System.out.println("\n" + consigne.toString() + "\n");
			Ouvrier PersonnelLibre = entrepot.getOuvrier(PersonnelsLibres.get(0));
			consigne.executionConsigne(PersonnelLibre, this.entrepot);
		}
	    else if(consigne instanceof ReceptionLot) {
	    	System.out.println("\n" + consigne.toString() + "\n");
	    	Ouvrier PersonnelLibre = entrepot.getOuvrier(PersonnelsLibres.get(0));
			consigne.executionConsigne(PersonnelLibre, this.entrepot);
		}
		else if(consigne instanceof ReceptionCommande) {
		
		}
		
	}
	
	
	
}
