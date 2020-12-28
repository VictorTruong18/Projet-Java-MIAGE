package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import appli.*;
import personnel.ChefBrico;
import personnel.ChefStock;
import personnel.Ouvrier;
import personnel.PieceDelaMaison;


class personnelTest {
	//Tests des creations des classes de Chef et d'ouvriers
	@Test
	void test1() {
		//La creation d'un chef de stock
		ChefStock chefStock1 = new ChefStock("Clooney", "George");
		//La creation d'un ouvrier qui a pour chef George clooney
		Ouvrier ouvrier1 = new Ouvrier("Pitt","Brad",chefStock1, PieceDelaMaison.Cuisine);
		
		//Les deux membres du personnel doivent avoir des identifiants uniques
		assertTrue(chefStock1.getId() != ouvrier1.getId());
		//Le chef a un salaire superieur a celui de l'ouvrier, chef salaire = 10, ouvrier salaire = 5
		assertTrue(chefStock1.getSALAIRE() > ouvrier1.getSALAIRE() 
				&& chefStock1.getSALAIRE() == 10 
				&& ouvrier1.getSALAIRE() == 5);
		assertEquals(chefStock1.getNom(),"Clooney" );
		assertEquals(chefStock1.getPrenom(),"George" );
		assertEquals(ouvrier1.getNom(),"Pitt" );
		assertEquals(ouvrier1.getPrenom(),"Brad" );
		
	}
	
	//Tests des methodes de l'interface ChefEquipe
	@Test
	void test2() {
		//la creation de deux chefs d'equipes
		ChefStock chefStock1 = new ChefStock("Fincher", "David");
		ChefBrico chefBrico1 = new ChefBrico("Tarantino", "Quentin");
		//le chef de stock recrute trois ouvriers 
		chefStock1.recruter("Afllec", "Ben", PieceDelaMaison.Salle_a_manger);
		chefStock1.recruter("Norton", "Edward", PieceDelaMaison.Wc);
		chefStock1.recruter("Garfield", "Andrew", PieceDelaMaison.Chambre);
		//le chef de brico recrute deux ouvriers
		chefBrico1.recruter("Dicaprio", "Leonardo", PieceDelaMaison.Salle_de_bain);
		chefBrico1.recruter("Waltz", "Christopher", PieceDelaMaison.Salon);
		//Test : getNbOuvriers(), et recruter()
		assertEquals(chefStock1.getNbOuvriers(),3);
		assertEquals(chefBrico1.getNbOuvriers(),2);
		//Test : renvoyer()
		chefStock1.renvoyer(4);
		assertEquals(chefStock1.getNbOuvriers(),2);
		//le chef de brico recrute trois ouvrier en plus
		chefBrico1.recruter("Foxx", "Jamie", PieceDelaMaison.Salle_a_manger);
		chefBrico1.recruter("Jackson", "Samuel", PieceDelaMaison.Salon);
		//le dernier ne sera pas ajouter 
		chefBrico1.recruter("Travolta", "John", PieceDelaMaison.Salon);
		//Test : InvalidNbOuvrierException
		assertEquals(chefBrico1.getNbOuvriers(),4);
		//Test : getIndiceOuvriers()
		List<Integer> indicesOuvriers = new ArrayList<>();
		indicesOuvriers.add(7);
		indicesOuvriers.add(9);
		assertEquals(chefBrico1.getIndiceOuvriers(PieceDelaMaison.Salle_de_bain), indicesOuvriers);
		
	}
	
	
	
	@Test
	void test3() {
		
	}
	

}
