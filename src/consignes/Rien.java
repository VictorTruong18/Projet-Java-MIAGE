package consignes;

import entrepot.Entrepot;
import personnel.Ouvrier;
import personnel.Personnel;

public class Rien extends Consigne {

	public Rien(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String s = "";
		s += "Consigne : Rien ";
		
		return s;
	}


	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		this.setAccepte(true);
		this.setRemplis(true);
	}

}
