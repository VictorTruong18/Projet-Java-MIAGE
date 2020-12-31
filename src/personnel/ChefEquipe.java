package personnel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exceptions.InvalidNbOuvrierException;

public class ChefEquipe extends Ouvrier {
	
	private final int SALAIRE;
	private final int MAX_OUVRIER;
	private LinkedList<Ouvrier> ouvriers;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param SALAIRE
	 * @param MAX_OUVRIER
	 */
	public ChefEquipe(String nom, String prenom, int SALAIRE, int MAX_OUVRIER) {
		super(nom, prenom, SALAIRE);
		this.SALAIRE = SALAIRE;
		this.MAX_OUVRIER = MAX_OUVRIER;
		this.ouvriers = new LinkedList<Ouvrier>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param specialite
	 * recrute un ouvrier spécialisé
	 */
	public void recruter(String nom, String prenom, PieceDelaMaison specialite) {
		try {
			//Si il reste de la place dans l'équipe du chef
			if(this.getNbOuvriers() < MAX_OUVRIER) {
				//On crée l'ouvrier
				Ouvrier nouvelleRecrue = new Ouvrier(nom,prenom,this,specialite);
				//On l'ajoute à l'équipe
				ouvriers.add(nouvelleRecrue);
			} else {
				throw new InvalidNbOuvrierException(this, this.MAX_OUVRIER);
			}
		} catch (InvalidNbOuvrierException e) {
			System.out.println(e.getMessage());
		}
	}
	


	/**
	 * @return la liste des ouvriers de l'équipe
	 */
	public LinkedList<Ouvrier> getOuvriers() {
		return ouvriers;
	}


	/**
	 * @return le nombre d'ouvriers de l'équipe
	 */
	public int getNbOuvriers() {
		return ouvriers.size();
	}


	/**
	 * @param id : l'id de l'ouvrier
	 */
	public void renvoyer(int id) {
		for(int i = 0; i < this.getNbOuvriers(); i++) {
			//Si l'ouvrier est trouvé
			if(this.ouvriers.get(i).getId() == id) {
				ouvriers.remove(i);
			}
		}
		
	}
	
	/**
	 *
	 */
	public String toString() {
		String s = "Chef de stock :  id : " + this.getId() + " nom : " + this.getNom() + " prenom : " + this.getPrenom() + "\n" ;
		for (Ouvrier o : this.ouvriers) {
			s += "id : " + o.getId() + " nom : " + o.getNom() + " prenom : " + o.getPrenom() + "\n";
		}
		return s;
	}



	/**
	 * @param specialite
	 * @return retourne les indices des ouvriers de la spécialité recherchée
	 */
	public List<Integer> getIndiceOuvriersSpiecialite(PieceDelaMaison specialite) {
		List<Integer> indices = new ArrayList<>();
		for(Ouvrier o : this.ouvriers) {
			if(o.getSpecialite() == specialite) {
				indices.add(o.getId());
			}
			
		}
		return indices;
	}
	
	/**
	 * @return la liste des indices des ouvriers libres
	 */
	public List<Integer> getIndiceOuvriersLibre() {
		List<Integer> indices = new ArrayList<>();
		for(Ouvrier o : this.ouvriers) {
			if(!o.isOccupe()) {
				indices.add(o.getId());
			}
			
		}
		return indices;
	}
	
	/**
	 *
	 */
	@Override
	public int getSALAIRE() {
		return SALAIRE;
	}


}
