package consignes;

import personnel.Ouvrier;

public class Rien extends Consigne {

	public Rien(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executionConsigne(Ouvrier o) {
		this.setRemplis(true);
		
	}

}
