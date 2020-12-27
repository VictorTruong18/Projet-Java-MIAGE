package appli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;
import personnel.Ouvrier;

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
		for(ChefEquipe c : this.chefsEquipes) {
			this.tresorie -= c.getSALAIRE();
			for(Ouvrier o : c.getOuvriers()) {
				this.tresorie -= o.getSALAIRE();
			}
		}
	}
	
	
	public double getTresorie() {
		return tresorie;
	}

	@Override
	public String toString() {
		String s = "";
		for(Rangee r : rangees)
			s += r.toString() + "\n";
		return s;
	}
	

}
