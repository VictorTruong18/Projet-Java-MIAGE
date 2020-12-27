package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class consigneTest {
	@Test
	void test1() throws FileNotFoundException {
		File file1 = new File("/Users/victortruong/Desktop/PROJET_JAVA/Projet-Java-MIAGE/fichiersTxt/file1.txt");
		Scanner scan = new Scanner(file1);
		
		while(scan.hasNextLine()){
			System.out.println(scan.nextLine());
		}
		scan.close();
	}
	
}
