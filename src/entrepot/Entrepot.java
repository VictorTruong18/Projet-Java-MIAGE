package entrepot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;
import personnel.Ouvrier;
import personnel.Personnel;

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
	
	public List<Integer> getIndiceOuvrierLibre(){
		List<Integer> indices = new ArrayList<>();
		for(ChefEquipe c : chefsEquipes) {
			if(!c.isOccupe()) {
				indices.add(c.getId());
			}
			indices.addAll(c.getIndiceOuvriersLibre());
		}
		return indices;	
	}
	
	public Ouvrier getOuvrier(int id) {
		for(ChefEquipe c : chefsEquipes) {
			if(c.getId() == id) {
				return c;
			}
			for(Ouvrier o : c.getOuvriers()) {
				if(o.getId() == id) {
					return o;
				}
			}
		}
		return null;
	}
	
	public Rangee getRangeeLibre(Lot lot) {
		for(Rangee r : this.rangees) {
			if(!r.placeDisponible(lot).isEmpty()) {
				return r;
			}
		}
		return null;
	}
	
	
	public double getTresorie() {
		return tresorie;
	}

	@Override
	public String toString() {
		String s = "\n Entrepot : \n";
		for(Rangee r : rangees)
			s += r.toString() + "\n";
		s += "Tresorie : " + this.tresorie + "\n";
		s += "Nombre de chefs d'Equipe : " + this.chefsEquipes.size() + "\n";
		int nbOuvriers = 0;
		for(ChefEquipe c : this.chefsEquipes)
			nbOuvriers += c.getNbOuvriers();
		s += "Nombre d'ouvriers : " + nbOuvriers + "\n";
		return s;
	}
	
	
	

}
