package appli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import consignes.ReceptionCommande;
import consignes.ReceptionLot;
import consignes.Rien;
import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Meuble;
import personnel.PieceDelaMaison;
import strategies.StrategieGloutton;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		File file1 = new File("/Users/victortruong/Desktop/PROJET_JAVA/Projet-Java-MIAGE/fichiersTxt/file1.txt");
		Scanner scan = new Scanner(file1);
		Entrepot entrepot = new Entrepot(2000);
		StrategieGloutton StrategieGloutton = new StrategieGloutton(entrepot);
		
		while(scan.hasNextLine()){
			String consigne = scan.nextLine();
			String[] params = consigne.split(" ");
			String titreConsigne = params[1];
			
			
			if(titreConsigne.equals("rien")) {
				Rien rienConsigne = new Rien(Integer.parseInt(params[0]));
				StrategieGloutton.executerConsigne(rienConsigne);
				
			} 
			else if (titreConsigne.equals("lot")) {
				Lot lot = new Lot(params[2],
						Double.parseDouble(params[3]), 
						Double.parseDouble(params[4]) ,
						Integer.parseInt(params[0]));
				ReceptionLot receptionLot = new ReceptionLot(Integer.parseInt(params[0]),lot);
				StrategieGloutton.executerConsigne(receptionLot);
				
			} else if (titreConsigne.equals("meuble")) {
				String nom = params[2];
				String pieceDelaMaison = params[3];
				PieceDelaMaison pieceMaison = null ;
				try {
					pieceMaison = PieceDelaMaison.valueOf(pieceDelaMaison);
				} catch (Exception e) {
					System.out.println("Veuillez verrifier dans le fichier d'entree que l'ecriture des pieces de la maison correspondent a l'ecriture des types enumere pieces de la maison");
				}
				int dureeConstruction = Integer.parseInt(params[4]);
				List<Lot> lots = new ArrayList<>();
				for(int i = 5; i < params.length; i++ ) {
					if(i % 2 != 0) {
						Lot lot = new Lot(params[i],Integer.parseInt(params[i+1]));
						lots.add(lot);
					} else {
						
					}
				}
				Meuble meuble = new Meuble(nom,pieceMaison,dureeConstruction,lots);
				ReceptionCommande commande = new ReceptionCommande(Integer.parseInt(params[0]),meuble);
				StrategieGloutton.executerConsigne(commande);
				
;			}
			
		}
		scan.close();
	}
		
	

}
