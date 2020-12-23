package personnel;

public class ChefStock extends Personnel implements ChefEquipe{
	private final int SALAIRE = 10;
	
	public ChefStock( String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	public int getSALAIRE() {
		return SALAIRE;
	}


	
}
