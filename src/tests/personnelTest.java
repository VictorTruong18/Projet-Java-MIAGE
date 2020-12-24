package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import appli.*;
import personnel.ChefBrico;
import personnel.ChefStock;
import personnel.Ouvrier;
import personnel.Specialite;


class personnelTest {
	
	@Test
	void test1() {
		//La creation d'un chef de stock
		ChefStock chefStock1 = new ChefStock("Clooney", "George");
		//La creation d'un ouvrier qui a pour chef George clooney
		Ouvrier ouvrier1 = new Ouvrier("Pitt","Brad",chefStock1, Specialite.CUISINE);
		
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
	
	@Test
	void test2() {
		//la creation de deux chefs d'equipes
		ChefStock chefStock1 = new ChefStock("Fincher", "David");
		ChefBrico chefBrico1 = new ChefBrico("Tarantino", "Quentin");
		
		//le chef de stock recrute trois ouvriers 
		chefStock1.recruter("Afllec", "Ben", Specialite.SALLE_A_MANGER);
		chefStock1.recruter("Norton", "Edward", Specialite.WC);
		chefStock1.recruter("Garfield", "Andrew", Specialite.CHAMBRE);
		
		//le chef de brico recrute deux ouvriers
		chefBrico1.recruter("Dicaprio", "Leonardo", Specialite.SALLE_DE_BAIN);
		chefBrico1.recruter("Waltz", "Christopher", Specialite.SALON);
		
		//On verifie que le nombre d'ouvriers pour chaque chef corespond bien
		assertEquals(chefStock1.getNbOuvriers(),3);
		assertEquals(chefBrico1.getNbOuvriers(),2);
		
		chefStock1.renvoyer(4);
		
		//On verifie que lorsque l'on renvoie un ouvrier ceci est pris en compte
		assertEquals(chefStock1.getNbOuvriers(),2);
		
		//le chef de brico recrute trois ouvrier en plus
		chefBrico1.recruter("Foxx", "Jamie", Specialite.SALLE_DE_BAIN);
		chefBrico1.recruter("Jackson", "Samuel", Specialite.SALON);
		
		//le dernier ne sera pas ajouter 
		chefBrico1.recruter("Travolta", "John", Specialite.SALON);
		assertEquals(chefBrico1.getNbOuvriers(),4);
	}
	

}
