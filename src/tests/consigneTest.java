package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import consignes.ReceptionLot;
import consignes.Rien;
import entrepot.Lot;

public class consigneTest {
	@Test
	void test1() throws FileNotFoundException {
		File file1 = new File("/Users/victortruong/Desktop/PROJET_JAVA/Projet-Java-MIAGE/fichiersTxt/file1.txt");
		Scanner scan = new Scanner(file1);
		
		while(scan.hasNextLine()){
			String consigne = scan.nextLine();
			String[] params = consigne.split(" ");
			String titreConsigne = params[1];
			
			
			if(titreConsigne == "rien") {
				Rien rienConsigne = new Rien(Integer.parseInt(params[0]));
			} 
			else if (titreConsigne == "lot") {
				Lot lot = new Lot(params[2],
						Double.parseDouble(params[3]), 
						Double.parseDouble(params[4]) ,
						Integer.parseInt(params[0]));
				ReceptionLot receptionLot = new ReceptionLot(Integer.parseInt(params[0]),lot);
			} else if (titreConsigne == "meuble") {
				
			}
			
		}
		scan.close();
	}
	
}
