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
	
	public Consigne(int id) {
		this.id = id;
		this.accepte = false;
		this.remplis = false;
	}

	public boolean isAccepte() {
		return accepte;
	}

	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}

	public boolean isRemplis() {
		return remplis;
	}

	public void setRemplis(boolean remplis) {
		this.remplis = remplis;
	}
	
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
	public abstract void executionConsigne(Ouvrier o, Entrepot e);
	
	
}
