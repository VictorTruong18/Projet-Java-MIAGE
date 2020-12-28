package consignes;

import entrepot.Meuble;
import personnel.Ouvrier;

public class ReceptionCommande extends Consigne {
	private Meuble meuble;

	public ReceptionCommande(int id, Meuble meuble) {
		super(id);
		this.meuble = meuble;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executionConsigne(Ouvrier o) {
		// TODO Auto-generated method stub
		
	}

}
