package personnel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exceptions.InvalidNbOuvrierException;

public class ChefEquipe extends Ouvrier {
	
	private final int SALAIRE;
	private final int MAX_OUVRIER;
	private LinkedList<Ouvrier> ouvriers;
	
	public ChefEquipe(String nom, String prenom, int SALAIRE, int MAX_OUVRIER) {
		super(nom, prenom, SALAIRE);
		this.SALAIRE = SALAIRE;
		this.MAX_OUVRIER = MAX_OUVRIER;
		this.ouvriers = new LinkedList<Ouvrier>();
		// TODO Auto-generated constructor stub
	}

	public void recruter(String nom, String prenom, PieceDelaMaison specialite) {
		try {
			if(this.getNbOuvriers() < MAX_OUVRIER) {
				Ouvrier nouvelleRecrue = new Ouvrier(nom,prenom,this,specialite);
				ouvriers.add(nouvelleRecrue);
			} else {
				throw new InvalidNbOuvrierException(this, this.MAX_OUVRIER);
			}
		} catch (InvalidNbOuvrierException e) {
			System.out.println(e.getMessage());
		}
	}
	


	public LinkedList<Ouvrier> getOuvriers() {
		return ouvriers;
	}


	public int getNbOuvriers() {
		return ouvriers.size();
	}


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



	public List<Integer> getIndiceOuvriersSpiecialite(PieceDelaMaison specialite) {
		List<Integer> indices = new ArrayList<>();
		for(Ouvrier o : this.ouvriers) {
			if(o.getSpecialite() == specialite) {
				indices.add(o.getId());
			}
			
		}
		return indices;
	}
	
	public List<Integer> getIndiceOuvriersLibre() {
		List<Integer> indices = new ArrayList<>();
		for(Ouvrier o : this.ouvriers) {
			if(!o.isOccupe()) {
				indices.add(o.getId());
			}
			
		}
		return indices;
	}
	
	@Override
	public int getSALAIRE() {
		return SALAIRE;
	}


}
