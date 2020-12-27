package personnel;

public class Ouvrier extends Personnel {
	
	
	private static final int SALAIRE = 5;
	private ChefEquipe chefEquipe;
	private Specialite specialite;

	public Ouvrier(String nom, String prenom,ChefEquipe chefEquipe,Specialite specialite) {
		super(nom, prenom, SALAIRE);
		this.chefEquipe = chefEquipe;
		this.specialite = specialite;
	
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public ChefEquipe getChefEquipe() {
		return chefEquipe;
	}

	public int getSALAIRE() {
		return SALAIRE;
	}
	
	
	

	
	

}

