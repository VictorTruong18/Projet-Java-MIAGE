package consignes;

import java.util.List;

import entrepot.Entrepot;
import personnel.Ouvrier;
import personnel.Personnel;
import personnel.Personnel;

public abstract class Consigne {
	private int id;
	private boolean accepte;
	private boolean remplis;
	
	/**
	 * @param id
	 */
	public Consigne(int id) {
		this.id = id;
		this.accepte = false;
		this.remplis = false;
	}

	/**
	 * @return si la consigne est acceptée
	 */
	public boolean isAccepte() {
		return accepte;
	}

	/**
	 * @param accepte : accepter la consigne ou non
	 */
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}

	/**
	 * @return si la consigne est remplie
	 */
	public boolean isRemplis() {
		return remplis;
	}

	/**
	 * @param remplis : rempli ou non
	 * modifier le statut de remplissage
	 */
	public void setRemplis(boolean remplis) {
		this.remplis = remplis;
	}
	
	/**
	 * @return s : état de la consigne
	 */
	public String toString()
	{	
		String s = "";
		if(this.accepte == false) {
			s += "Ceci represente la consigne numero " + this.id + " et n'a toujours pas ete accepte";
		} else {
			s += "Ceci represente la consigne numero " + this.id + " et a ete accepte";
		}
		return s;
	}
	/**
	 * @param o : l'ouvrier qui execute la consigne
	 * @param e : l'entrepot concerné par cette consigne
	 */
	public abstract void executionConsigne(Ouvrier o, Entrepot e);
	
	
}
