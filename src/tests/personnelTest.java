package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import appli.*;
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
	

}
