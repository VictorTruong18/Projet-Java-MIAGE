package personnel;

public class Ouvrier extends Personnel {
	
	private final int SALAIRE = 5;
	private ChefEquipe chefEquipe;

	public Ouvrier(String nom, String prenom,ChefEquipe chefEquipe) {
		super(nom, prenom);
		this.chefEquipe = chefEquipe;
	
	}

	public ChefEquipe getChefEquipe() {
		return chefEquipe;
	}

	public int getSALAIRE() {
		return SALAIRE;
	}
	
	

	
	

}

