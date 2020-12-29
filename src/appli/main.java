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
import entrepot.Rangee;
import personnel.ChefBrico;
import personnel.ChefStock;
import personnel.PieceDelaMaison;
import strategies.StrategieGloutton;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		/*--------------------------------INITIALISATION FILE READER ------------------------------------------------- */
		
		File file1 = new File("/Users/victortruong/Desktop/PROJET_JAVA/Projet-Java-MIAGE/fichiersTxt/file1.txt");
		Scanner scan = new Scanner(file1);
		
		
		
		
		/*--------------------------------INITIALISATION DE ENTREPOT ------------------------------------------------- */
		
		Entrepot entrepot = new Entrepot(2000);
		//Ajout des rangees
		Rangee rangee1 = new Rangee(5);
		Rangee rangee2 = new Rangee(5);
		entrepot.ajouterRangee(rangee1);
		entrepot.ajouterRangee(rangee2);
		//Ajout des chefs Equipes
		ChefStock chefStock1 = new ChefStock("Fincher", "David");
		ChefBrico chefBrico1 = new ChefBrico("Tarantino", "Quentin");
		entrepot.recruterChefEquipe(chefStock1);
		entrepot.recruterChefEquipe(chefBrico1);
		
		
		
		/*--------------------------------INITIALIALISATION STRATEGIE ------------------------------------------------- */
		
		StrategieGloutton StrategieGloutton = new StrategieGloutton(entrepot);
		
		
		
		/*---------------------------------------LA SIMULATION--------------------------------------------------------- */
		
	
		
	
		
		
		int pasTemps = 1;
		
		while(scan.hasNextLine()){
			
			System.out.println("Pas de Temps : " + pasTemps + "-----------------------------------");
			pasTemps++;
		
			String consigne = scan.nextLine();
			String[] params = consigne.split(" ");
			String titreConsigne = params[1];
			
			//L'instruction est une consigne RIEN
			if(titreConsigne.equals("rien")) {
				Rien rienConsigne = new Rien(Integer.parseInt(params[0]));
				StrategieGloutton.decisionConsigne(rienConsigne);
				entrepot.payerPersonnel();
				System.out.println(entrepot.toString());
			} 
			
			//L'instruction est une consigne LOT
			else if (titreConsigne.equals("lot")) {
				Lot lot = new Lot(params[2],
						Double.parseDouble(params[3]), 
						Double.parseDouble(params[4]) ,
						Integer.parseInt(params[0]));
				ReceptionLot receptionLot = new ReceptionLot(Integer.parseInt(params[0]),lot);
				StrategieGloutton.decisionConsigne(receptionLot);
				entrepot.payerPersonnel();
				System.out.println(entrepot.toString());
				
			} 
			
			//L'insturction est une consigne MEUBLE
			else if (titreConsigne.equals("meuble")) {
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
				
				StrategieGloutton.decisionConsigne(commande);
				
				entrepot.payerPersonnel();
				;			
			} 
			else {
				System.out.println("Une des consignes n'a pas ete reconnonu parmi celles existantes : rien - lot - meuble");
			}
			
		}
		scan.close();
	}
		
	

}
