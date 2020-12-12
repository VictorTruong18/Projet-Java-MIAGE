package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import appli.*;

class rangeeTest {

	@Test
	void test1() {
		
		//Initialisation de l'Entrepot
		Entrepot entrepot = new Entrepot();
		//Creation de deux rangees de volume 5
		Rangee rangee1 = new Rangee(5);
		Rangee rangee2 = new Rangee(5);
		//Creation d'un lot de volume 6
		Lot planchesDeBoie = new Lot(1,"PlanchesDeBoie",10,145.00,6);
		//L'Entrepot ajoute les rangees
		entrepot.ajouterRangee(rangee1);
		entrepot.ajouterRangee(rangee2);
		//entrepot.ajouterUnLot(planchesDeBoie);
		
	}
	
	@Test
	void test2() {
		
	}
	
	@Test
	void test3() {
		
	}

}
