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
	 * @param tresorie : la tr�sorie de l'entrepot
	 */
	public Entrepot(double tresorie) {
		this.lots = new ArrayList<>();
		this.rangees = new ArrayList<>();
		this.chefsEquipes = new LinkedList<>();
		this.commandes = new LinkedList<>();
		this.tresorie = tresorie;
	}
	
	/**
	 * @param rangee : la rang�e
	 */
	public void ajouterRangee(Rangee rangee) {
		this.rangees.add(rangee);
	}
	
	/**
	 * @param meuble : le meuble
	 * ajoute une commande du meuble donn� � l'entrepot
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
		boolean actionRemplie = false;
		for(Rangee r : this.rangees) {
			if(actionRemplie == true) {
				
			} else {
				
				actionRemplie = r.retirerLotNom(nom, volume);
			}
			
			
		}
		
	}
	
	/**
	 * @return la construction du meuble est possible
	 * v�rifie si la construciton du meuble est bien r�alisable
	 */
//	public boolean peutConstruire() {
//		
//	
//	}
//	
	/**
	 * @param meuble : le meuble
	 * @return la possibilit� de la construction
	 */
	public boolean peutConstruire(Meuble meuble) {	
		
		List<String> nomMeubles = new ArrayList<>();
		for(Lot l : meuble.getLotsMeuble()) {
			nomMeubles.add(l.getNom());
		}
		
		List<String> nomLots = new ArrayList<>();
		for(Lot l : this.lots) {
			nomLots.add(l.getNom());
		}
	
		return nomLots.containsAll(nomMeubles);

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
			//Enleve le salaire de la tr�sorie
			this.tresorie -= c.getSALAIRE();
			for(Ouvrier o : c.getOuvriers()) {
				//D�duit le salaire des ouvriers de la tr�sorie
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
			//V�rifie si un chef est dispo
			if(!c.isOccupe()) {
				
				indices.add(c.getId());
			}
			//Ajoute tous les ouvriers libres parmi l'�quipe du chef en question
			indices.addAll(c.getIndiceOuvriersLibre());
		}
		return indices;	
	}
	
	/**
	 * @param id
	 * @return l'ouvrier recherch�
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
	 * @return la premi�re rang�e disponible pour accueillir le lot
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
