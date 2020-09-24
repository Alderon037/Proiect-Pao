package petshop;
import javax.swing.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.*;
public class Main {

	public static void main(String args[]) throws IOException{
		
		Service s = new Service();
		Setup set = Setup.getInstance();
		//set.AddUserCSV(s,"Employees.csv");
		
		set.AddUserSQL(s);
		//set.AddAnimalCSV(s, "Monkey.csv", "Parrot.csv", "Lion.csv");
		set.AddAnimalSQL(s);
		set.CreateSQLTable();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Doriti sa utilizati interfata grafica ? 1 - da 0 - nu");
		int y = keyboard.nextInt();
		if(y == 0) {
			System.out.println("Apasati 1 pentru a introduce un nou angajat al gradinii zoologice");
			System.out.println("Apasati 2 pentru a afla informatii despre un angajat(detaliat)");
			System.out.println("Apasati 3 pentru a afla informatii despre animalele de care are grija un angajat");
			System.out.println("Apasati 4 pentru a concedia un angajat");
			System.out.println("Apasati 5 pentru a afisa lista angajatilor");
			System.out.println("Apasati 6 pentru a afisa salariul angajatilor");
			System.out.println("Apasati 7 pentru a muta un animal aflat in grija unui angajat in grija altui angajat");
			System.out.println("Apasati 8 pentru a sterge un animal din grija unui angajat");//
			System.out.println("Apasati 9 pentru a adauga un animal in grija unui angajat");
			System.out.println("Apasati 10 pentru a interactiona cu animalele unui angajat");//
			System.out.println("Apasati 0 pentru a iesi");
		

		
			
			int x = keyboard.nextInt();
			while(x != 0) {
				s.Request(x , 0);
				x = keyboard.nextInt();
			}
		}else {
			new GUI(s);
		}
		//set.WriteCSV(s);
		set.WriteToSQL(s);
		s.callAudit();
		
	}
}
