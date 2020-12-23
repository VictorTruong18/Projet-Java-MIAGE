package personnel;

public class Personnel {
	
	private static int nbPersonnel = 0;
	private int id;
	private String nom;
	private String prenom;

	
	public Personnel(String nom, String prenom) {
		this.id = nbPersonnel;
		this.nbPersonnel++;
		this.nom = nom;
		this.prenom = prenom;
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




}
