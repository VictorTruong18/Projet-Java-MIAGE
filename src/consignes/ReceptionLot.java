package consignes;

import java.util.List;

import entrepot.Lot;
import personnel.Ouvrier;
import personnel.Personnel;

public class ReceptionLot extends Consigne {
	private Lot lot;
	
	public ReceptionLot(int id, Lot lot) {
		super(id);
		this.lot = lot;
	}


	@Override
	public void executionConsigne(Ouvrier o) {
		// TODO Auto-generated method stub
		
	}
	
}
