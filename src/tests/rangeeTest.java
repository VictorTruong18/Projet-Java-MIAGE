package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		//Creation d'un lot de volume 4
		Lot planchesDeBoie = new Lot(1,"PlanchesDeBoie",10,145.00,4);
		//L'Entrepot ajoute les rangees
		entrepot.ajouterRangee(rangee1);
		entrepot.ajouterRangee(rangee2);
		List<Integer> placeDisponible = new ArrayList<>();
		placeDisponible.add(0);
		placeDisponible.add(1);
		assertEquals(rangee1.placeDisponible(planchesDeBoie),placeDisponible);	
		assertEquals(rangee2.placeDisponible(planchesDeBoie),placeDisponible);
	}
	

}
