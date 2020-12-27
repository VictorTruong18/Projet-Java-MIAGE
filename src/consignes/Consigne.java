package consignes;

import java.util.List;

import personnel.Ouvrier;
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
	
	public abstract void executionConsigne(Ouvrier o);
	
}
