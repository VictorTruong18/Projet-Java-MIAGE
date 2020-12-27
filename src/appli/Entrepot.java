package appli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;

public class Entrepot {
	
	private List<Rangee> rangees;
	private List<ChefEquipe> chefsEquipes; 
	private List<Commande> commandes;
	private double tresorie;
	
	
	public Entrepot(double tresorie) {
		this.rangees = new ArrayList<>();
		this.chefsEquipes = new LinkedList<>();
		this.commandes = new LinkedList<>();
		this.tresorie = tresorie;
	}
	
	public void ajouterRangee(Rangee rangee) {
		this.rangees.add(rangee);
	}
	
	
	public void recruterChefEquipe(ChefEquipe chefEquipe) {
		this.chefsEquipes.add(chefEquipe);	
	}
	
	public void payerPersonnel() {
		
	}
	
	
	@Override
	public String toString() {
		String s = "";
		for(Rangee r : rangees)
			s += r.toString() + "\n";
		return s;
	}
	

}
