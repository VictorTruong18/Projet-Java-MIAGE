package personnel;

public class Personnel {
	
	private static int nbPersonnel = 0;
	private int id;
	private String nom;
	private String prenom;
	private final int SALAIRE;
	private boolean occupe;

	
	/**
	 * @param nom
	 * @param prenom
	 * @param SALAIRE
	 */
	public Personnel(String nom, String prenom, int SALAIRE) {
		this.id = nbPersonnel;
		this.nbPersonnel++;
		this.nom = nom;
		this.prenom = prenom;
		this.SALAIRE = SALAIRE;
		this.occupe = false;
	}


	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @return
	 */
	public int getSALAIRE() {
		return SALAIRE;
	}
	
	/**
	 * @return
	 */
	public boolean isOccupe() {
		return occupe;
	}



}
