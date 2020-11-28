package appli;

import java.util.List;

public class Entrepôt {
	
	private Rangée[] rangées;
	
	
	public Entrepôt(int nbRangées) {
		this.rangées = new Rangée[nbRangées];
	}
	
	public void initialiserEntrepots(int longueur) {
		for(Rangée r:rangées)
			r.setLongueur(longueur);
		
	}
	
	

}
