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
	
	/**
	 * @param nom
	 * @param pieceMaison
	 * @param dureeConstruction
	 * @param lots
	 */
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

	/**
	 * @return les lots du meuble
	 */
	public List<Lot> getLotsMeuble() {
		return lotsMeuble;
	}

	/**
	 * @return la durée de construction du meuble
	 */
	public int getDureeConstruction() {
		return dureeConstruction;
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return la pièce de la maison du meuble
	 */
	public PieceDelaMaison getPieceMaison() {
		return pieceMaison;
	}

	/**
	 * @return le prix du meuble
	 */
	public double getPrix() {
		return prix;
	}

	
	

}
