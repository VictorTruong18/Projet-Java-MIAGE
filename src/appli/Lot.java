package appli;

public class Lot {
	
	private int idLot, volume;
	private String nom;
	private double poids, prix;
	
	public Lot(int idLot, String nom, double poids, double prix, int volume) {
		this.idLot = idLot;
		this.volume = volume;
		this.nom = nom;
		this.poids = poids;
		this.prix = prix;
	}
	
	

}
