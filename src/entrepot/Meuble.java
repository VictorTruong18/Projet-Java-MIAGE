package entrepot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import personnel.PieceDelaMaison;


public class Meuble {
	
	private List<Lot> lotsMeuble;
	private int dureeConstruction;
	private String nom;
	private PieceDelaMaison pieceMaison;
	private double prix;
	
	public Meuble( String nom, 
			PieceDelaMaison pieceMaison,
			int dureeConstruction,
			List<Lot> lots ) {
		
		this.dureeConstruction = dureeConstruction;
		this.pieceMaison = pieceMaison;
		this.nom = nom;
		this.pieceMaison = pieceMaison;
		this.lotsMeuble = lots;
		
		double prix = 0;
		for(Lot l : lotsMeuble) {
			prix += l.getPrix();
			
		}
		this.prix = prix;
	}

	public List<Lot> getLotsMeuble() {
		return lotsMeuble;
	}

	public int getDureeConstruction() {
		return dureeConstruction;
	}

	public String getNom() {
		return nom;
	}

	public PieceDelaMaison getPieceMaison() {
		return pieceMaison;
	}

	public double getPrix() {
		return prix;
	}

	
	

}
