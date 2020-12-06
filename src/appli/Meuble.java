package appli;

import java.util.HashMap;
import java.util.Map;

public class Meuble {
	
	private Lot[] lotsMeuble;
	private int idMeuble, dureeConstruction;
	private String nom;
	private PieceMaison pieceMaison;
	private double prix;
	
	public Meuble(int idMeuble, int dureeConstruction, String nom, PieceMaison pieceMaison,
			Lot lots[]) {
		this.idMeuble = idMeuble;
		this.dureeConstruction = dureeConstruction;
		this.nom = nom;
		this.pieceMaison = pieceMaison;
		
		for(int i =0; i < lots.length; ++i) {
			lotsMeuble[i] = lots[i];
			prix += (lotsMeuble[i].getVolume() * lotsMeuble[i].getPrix()); 
		}
		
	}

	public double getPrix() {
		return prix;
	}
	
	
	

}
