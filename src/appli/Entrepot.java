package appli;

import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;

public class Entrepot {
	
	private Rangee[] rangee;
	private double tresorie;
	private List<ChefEquipe> chefsEquipes; 
	private List<Commande> commandes;
	private boolean recruter, virer;
	
	public Entrepot(int nbRangées) {
		this.rangee = new Rangee[nbRangées];
		this.chefsEquipes = new LinkedList<>();
		commandes = new LinkedList<>();
		recruter = true;
		virer = true;
	}
	
	public void initialiserEntrepot(int longueur) {
		for(Rangee r:rangee)
			r.setLongueur(longueur);
	}
	
	public void recruterPersonnel(String typePers) {
		if(recruter) {
			
		}
	}
	
	public void virerPersonnel(String nom) {
		if(virer) {
			
		}
	}
	

}
