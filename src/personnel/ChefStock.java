package personnel;

import java.awt.List;
import java.util.LinkedList;
import java.util.Stack;

public class ChefStock extends Personnel implements ChefEquipe{
	private final int SALAIRE = 10;
	private LinkedList<Ouvrier> ouvriers;
	
	public ChefStock( String nom, String prenom) {
		super(nom, prenom);
		this.ouvriers = new LinkedList<Ouvrier>();
		// TODO Auto-generated constructor stub
	}

	public int getSALAIRE() {
		return SALAIRE;
	}
	
	@Override
	public void recruter(String nom, String prenom, Specialite specialite) {
		Ouvrier nouvelleRecrue = new Ouvrier(nom,prenom,this,specialite);
		ouvriers.add(nouvelleRecrue);
	}
	
	

	@Override
	public int getNbOuvriers() {
		return ouvriers.size();
	}

	@Override
	public void renvoyer(int id) {
		for(int i = 0; i < this.getNbOuvriers(); i++) {
			if(this.ouvriers.get(i).getId() == id) {
				ouvriers.remove(i);
			}
		}
		
	}
	
	public String toString() {
		String s = "Chef de stock :  id : " + this.getId() + " nom : " + this.getNom() + " prenom : " + this.getPrenom() + "\n" ;
		for (Ouvrier o : this.ouvriers) {
			s += "id : " + o.getId() + " nom : " + o.getNom() + " prenom : " + o.getPrenom() + "\n";
		}
		return s;
	}
	
	
}
