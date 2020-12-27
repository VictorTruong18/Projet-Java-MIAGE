package appli;

public class Lot {
	
	private static int nbLot = 0;
	private int idLot, volume;
	private String nom;
	private double poids, prix;
	
	
	public int getIdLot() {
		return idLot;
	}

	public Lot(String nom, double poids, double prix, int volume) {
		this.idLot = nbLot;
		this.nbLot++;
		this.volume = volume;
		this.nom = nom;
		this.poids = poids;
		this.prix = prix;
	}
	
	public int getVolume() {
		return volume;
	}

	public String getNom() {
		return nom;
	}
	
	public double getPrix() {
		return prix;
	}
	
	

}