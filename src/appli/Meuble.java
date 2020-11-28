package appli;

import java.util.HashMap;
import java.util.Map;

public class Meuble {
	
	private Map<String,Integer> lotsMeuble;
	private int idMeuble, dureeConstruction;
	private String nom;
	private PieceMaison pieceMaison;
	public Meuble(int idMeuble, int dureeConstruction, String nom, PieceMaison pieceMaison,
			String [] typeLot, int [] volumeLot) {
		this.idMeuble = idMeuble;
		this.dureeConstruction = dureeConstruction;
		this.nom = nom;
		this.pieceMaison = pieceMaison;
		lotsMeuble = new HashMap<>();
		
		for(int i =0; i < typeLot.length; ++i)
			lotsMeuble.put(typeLot[i], volumeLot[i]);
	}
	
	
	

}
