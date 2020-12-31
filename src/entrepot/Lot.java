package entrepot;

public class Lot {
	
	private static int nbLot = 0;
	private int idLot, volume;
	private String nom;
	private double poids, prix;
	
	
	/**
	 * @return l'id du lot
	 */
	public int getIdLot() {
		return idLot;
	}

	/**
	 * @param nom
	 * @param poids
	 * @param prix
	 * @param volume
	 */
	public Lot(String nom, double poids, double prix, int volume) {
		this.idLot = nbLot;
		this.nbLot++;
		this.volume = volume;
		this.nom = nom;
		this.poids = poids;
		this.prix = prix;
	}
	
	/**
	 * @param nom
	 * @param volume
	 */
	public Lot(String nom, int volume) {
		this.nom = nom;
		this.volume = volume;
	}
	/**
	 * @return le volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @return le poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * @param poids
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @return le prix
	 */
	public double getPrix() {
		return prix;
	}
	
	

}