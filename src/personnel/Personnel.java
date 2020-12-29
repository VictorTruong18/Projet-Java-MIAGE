package personnel;

public class Personnel {
	
	private static int nbPersonnel = 0;
	private int id;
	private String nom;
	private String prenom;
	private final int SALAIRE;
	private boolean occupe;

	
	public Personnel(String nom, String prenom, int SALAIRE) {
		this.id = nbPersonnel;
		this.nbPersonnel++;
		this.nom = nom;
		this.prenom = prenom;
		this.SALAIRE = SALAIRE;
		this.occupe = false;
	}


	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public int getSALAIRE() {
		return SALAIRE;
	}
	
	public boolean isOccupe() {
		return occupe;
	}



}
