package appli;

import java.util.List;

public class Entrep�t {
	
	private Rang�e[] rang�es;
	
	
	public Entrep�t(int nbRang�es) {
		this.rang�es = new Rang�e[nbRang�es];
	}
	
	public void initialiserEntrepots(int longueur) {
		for(Rang�e r:rang�es)
			r.setLongueur(longueur);
		
	}
	
	

}
