package entrepot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import personnel.ChefEquipe;
import personnel.Ouvrier;
import personnel.Personnel;

public class Entrepot {
	private List<Lot> lots;
	private List<Rangee> rangees;
	private List<ChefEquipe> chefsEquipes; 
	private List<Meuble> commandes;
	private double tresorie;
	
	
	
	/**
	 * @param tresorie : la trésorie de l'entrepot
	 */
	public Entrepot(double tresorie) {
		this.lots = new ArrayList<>();
		this.rangees = new ArrayList<>();
		this.chefsEquipes = new LinkedList<>();
		this.commandes = new LinkedList<>();
		this.tresorie = tresorie;
	}
	
	/**
	 * @param rangee : la rangée
	 */
	public void ajouterRangee(Rangee rangee) {
		this.rangees.add(rangee);
	}
	
	/**
	 * @param meuble : le meuble
	 * ajoute une commande du meuble donné à l'entrepot
	 */
	public void ajouterCommande(Meuble meuble) {
		this.commandes.add(meuble);
	}
	
	/**
	 * @param l
	 */
	public void ajouterLot(Lot l) {
		this.lots.add(l);
	}
	
	/**
	 * @param nom : le nom du lot
	 * @param volume : le volume du lot
	 */
	public void retirerLot(String nom, int volume) {
		boolean isRetire = false;
		for(Rangee rangee : this.rangees) {
			//Parcours les rangées et vérifie si un lot est disponible pour
			//etre utilisé
			if(!isRetire && rangee.contienLot(nom)) {
				rangee.retirerLot(nom, volume);
				isRetire = true;
			}
		}
	}
	
	/**
	 * @return la construction du meuble est possible
	 * vérifie si la construciton du meuble est bien réalisable
	 */
	public boolean peutConstruire() {
		if(!this.commandes.isEmpty()) {
			for(Meuble meuble : this.commandes) {
				int nombreDeLot = meuble.getLotsMeuble().size();
				int countLot = 0;
				for(Lot lotMeuble : meuble.getLotsMeuble()) {
					
					for(Lot lotEntrepot : this.lots) {
						//Vérifie pour chaque lot si il est contenu dans l'entrepot
						if(lotMeuble.getNom().equals(lotEntrepot.getNom())) {
							//On augmente le nb de lot contenu
							countLot++;
						} if(nombreDeLot == countLot) {		
							//Si tous les lots sont la, le compte est bon !
							return true;
						} 
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * @param meuble : le meuble
	 * @return la possibilité de la construction
	 */
	public boolean peutConstruire(Meuble meuble) {
		int nombreDeLot = meuble.getLotsMeuble().size();
		int countLot = 0;
		//Les lots nécessaires pour la construction du meuble
		for(Lot lotMeuble : meuble.getLotsMeuble()) {
			
			//Les lots de l'entrepot
			for(Lot lotEntrepot : this.lots) {
				//Vérifie pour chaque lot si il est contenu dans l'entrepot
				if(lotMeuble.getNom().equals(lotEntrepot.getNom())) {
					//On augmente le nb de lot contenu
					countLot++;
					//Si tous les lots sont la, le compte est bon !
				} if(nombreDeLot == countLot) {		
					return true;
				} 
			}
		}
		return false;
		
	}
	
	/**
	 * @param chefEquipe
	 */
	public void recruterChefEquipe(ChefEquipe chefEquipe) {
		this.chefsEquipes.add(chefEquipe);	
	}
	
	/**
	 * 
	 */
	public void payerPersonnel() {
		for(ChefEquipe c : this.chefsEquipes) {
			//Enleve le salaire de la trésorie
			this.tresorie -= c.getSALAIRE();
			for(Ouvrier o : c.getOuvriers()) {
				//Déduit le salaire des ouvriers de la trésorie
				this.tresorie -= o.getSALAIRE();
			}
		}
	}
	
	/**
	 * @return la liste d'indice des ouvriers libres
	 */
	public List<Integer> getIndiceOuvrierLibre(){
		List<Integer> indices = new ArrayList<>();
		
		for(ChefEquipe c : chefsEquipes) {
			//Vérifie si un chef est dispo
			if(!c.isOccupe()) {
				
				indices.add(c.getId());
			}
			//Ajoute tous les ouvriers libres parmi l'équipe du chef en question
			indices.addAll(c.getIndiceOuvriersLibre());
		}
		return indices;	
	}
	
	/**
	 * @param id
	 * @return l'ouvrier recherché
	 */
	public Ouvrier getOuvrier(int id) {
		for(ChefEquipe c : chefsEquipes) {
			//Retourne le chef si il correspond
			if(c.getId() == id) {
				return (Ouvrier) c;
			}
			for(Ouvrier o : c.getOuvriers()) {
				//Retourne l'ouvrier correspondant
				if(o.getId() == id) {
					return o;
				}
			}
		}
		return null;
	}
	
	/**
	 * @param lot
	 * @return la première rangée disponible pour accueillir le lot
	 */
	public Rangee getRangeeLibre(Lot lot) {
		for(Rangee r : this.rangees) {
			if(!r.placeDisponible(lot).isEmpty()) {
				return r;
			}
		}
		return null;
	}
	
	
	/**
	 * @return
	 */
	public double getTresorie() {
		return tresorie;
	}

	/**
	 *
	 */
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
