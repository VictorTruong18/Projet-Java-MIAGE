package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import appli.*;
import entrepot.Entrepot;
import entrepot.Lot;
import entrepot.Rangee;
import personnel.ChefBrico;
import personnel.ChefStock;
import personnel.PieceDelaMaison;

class entrepotTest {

	@Test
	void test1() {
		
		//Initialisation de l'Entrepot avec une tresorie de 2000
		Entrepot entrepot = new Entrepot(2000);
		//Creation de deux rangees de volume 5
		Rangee rangee1 = new Rangee(5);
		Rangee rangee2 = new Rangee(5);
		//Creation d'un lot de volume 4
		Lot planchesDeBoie = new Lot("PlanchesDeBoie",10,145.00,4);
		//L'Entrepot ajoute les rangees
		entrepot.ajouterRangee(rangee1);
		entrepot.ajouterRangee(rangee2);
		List<Integer> placeDisponible = new ArrayList<>();
		placeDisponible.add(0);
		placeDisponible.add(1);
		assertEquals(rangee1.placeDisponible(planchesDeBoie),placeDisponible);	
		assertEquals(rangee2.placeDisponible(planchesDeBoie),placeDisponible);
		
		rangee1.ajouterLot(planchesDeBoie, 0);
		System.out.println(entrepot.toString());
		rangee1.retirerLot(planchesDeBoie);
		System.out.println(entrepot.toString());
	
	}
	
	
	@Test
	void test2() {
		//Initialisation de l'Entrepot avec une tresorie de 2000
		Entrepot entrepot = new Entrepot(2000);
		
		//la creation de deux chefs d'equipes
		ChefStock chefStock1 = new ChefStock("Fincher", "David");
		ChefBrico chefBrico1 = new ChefBrico("Tarantino", "Quentin");
		
		entrepot.recruterChefEquipe(chefStock1);
		entrepot.recruterChefEquipe(chefBrico1);
		
		//le chef de stock recrute trois ouvriers 
		chefStock1.recruter("Afllec", "Ben", PieceDelaMaison.Salle_a_manger);
		chefStock1.recruter("Norton", "Edward", PieceDelaMaison.Wc);
		chefStock1.recruter("Garfield", "Andrew", PieceDelaMaison.Chambre);
		//le chef de brico recrute deux ouvriers
		chefBrico1.recruter("Dicaprio", "Leonardo", PieceDelaMaison.Salle_de_bain);
		chefBrico1.recruter("Waltz", "Christopher", PieceDelaMaison.Salon);
		
		
		entrepot.payerPersonnel();
		assertEquals(2000-45,entrepot.getTresorie());
		
	}

}
