package consignes;

import entrepot.Entrepot;
import entrepot.Meuble;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionCommande extends Consigne {
	private Meuble meuble;

	public ReceptionCommande(int id, Meuble meuble) {
		super(id);
		this.meuble = meuble;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executionConsigne(Ouvrier o, Entrepot e) {
		// TODO Auto-generated method stub
		
	}




	

}
