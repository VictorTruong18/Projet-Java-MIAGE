package appli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;

public class Entrepot {
	
	private List<Rangee> rangees;
	private double tresorie;
	private List<ChefEquipe> chefsEquipes; 
	private List<Commande> commandes;
	private boolean recruter, virer;
	
	public Entrepot() {
		this.rangees = new ArrayList<>();
		this.chefsEquipes = new LinkedList<>();
		this.commandes = new LinkedList<>();
		this.recruter = true;
		this.virer = true;
	}
	
	public void ajouterRangee(Rangee rangee) {
		this.rangees.add(rangee);
	}
	
	public void ajouterUnLot(Lot l) {
		for(Rangee r : this.rangees) {
			if(r.placeDisponible(l)) {
				r.ajouterLot(l);
			}
		}
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
