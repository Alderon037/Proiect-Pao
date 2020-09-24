package petshop;


import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;


public class Setup {
	//private static String filename = "Employees.csv";
	private static Setup single_instance = null; 
	int i = 0;
    private Setup() 
    { 
       
    	System.out.println("Se incarca datele");
    } 
    public static Setup getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Setup(); 
  
        return single_instance; 
    } 
    public static void CreateSQLTable() {
    	Connection conn = null;
    	try {
    		int ok = 1;
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
    		Statement stmt = null;
    		stmt = conn.createStatement();
    		DatabaseMetaData md = conn.getMetaData();
    		ResultSet rs = md.getTables(null, null, "%", null);
    		while (rs.next()) {
    			if(rs.getString(3).equals("angajati"))
    				ok = 0;
    		  }
    		if(ok == 1) {
    			stmt.executeUpdate("create table Angajati (	Nume VARCHAR(20) primary key, Varsta int, Functie int, NumarAnimale  );");
    		}else {
    			System.out.println("Tabel deja existent");
    		}
    		//ResultSet rs = stmt.executeQuery("select * from `angajati` ");
    	}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
	public static void AddUserCSV(Service serv, String name) {
		String s = null;
		try {
			Scanner scan = new Scanner((new File(name)));
			s = scan.nextLine();
			//String[] info = s.split(";");
			while(scan.hasNext()){
				String n = scan.nextLine();
				String[] info = n.split(";");
				//System.out.println(info[0]);
				serv.addEmployee(info[0],Integer.parseInt(info[1]),Integer.parseInt(info[2]));
			}
	    
		} catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	    }
		

	}
	public static void AddAnimalCSV(Service serv, String name1, String name2, String name3) {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		try {
			Scanner scan1 = new Scanner((new File(name1)));
			s1 = scan1.nextLine();
			//String[] info = s.split(";");
			while(scan1.hasNext()){
				String n = scan1.nextLine();
				String[] info = n.split(";");
				//System.out.println(info[2]);
				serv.addAnimal(info[0],Integer.parseInt(info[1]),info[2],1);
			}
			Scanner scan2 = new Scanner((new File(name2)));
			s2 = scan2.nextLine();
			//String[] info = s.split(";");
			while(scan2.hasNext()){
				String n = scan2.nextLine();
				String[] info = n.split(";");
				//System.out.println(info[2]);
				serv.addAnimal(info[0],Integer.parseInt(info[1]),info[2],2);
			}
			Scanner scan3 = new Scanner((new File(name3)));
			s3 = scan3.nextLine();
			//String[] info = s.split(";");
			while(scan3.hasNext()){
				String n = scan3.nextLine();
				String[] info = n.split(";");
				//System.out.println(info[2]);
				serv.addAnimal(info[0],Integer.parseInt(info[1]),info[2],3);
			}
	    
		} catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	    }
	}
	public static void WriteCSV(Service serv)
	{
		List<Employee> e = serv.getList();
		int j = 0;
		String data =  "Numele angajatului ; Varsta angajatului ; Functia anagajatului ; Numarul de animale de care are grija angajatul\n";
		//System.out.println(e.get(j).SalaryCalculator());
		for (int i = 0; i < e.size(); i++) {
			data += e.get(i).GetName() + ";" + e.get(i).GetAge() + ";" +
                    e.get(i).GetJob() + ";" + e.get(i).GetNrAnimals() + "\n";
			//1-ZooKeeper, 2-Vet, 3-AuxiliaryEmployee
		}
        try {
           
            FileWriter writer = new FileWriter("angajati.csv");
            writer.append(data);
            writer.flush();
            writer.close();

        } catch (IOException n) {
            System.out.println(n.getMessage());
        }
	}
	
	
	
	public static void AddUserSQL(Service serv)
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	            // handle the error
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
			Statement stmt = null;
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `employees` ");
            while (rs.next())
            {
                /** Incarc in memorie utilizatorul*/
            	serv.addEmployee(rs.getString("Nume"),rs.getInt("Functie"),rs.getInt("Varsta"));
            }
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	public static void AddAnimalSQL(Service serv) {
		
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	            // handle the error
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
			Statement stmt = null;
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `Monkey` ");
            while (rs.next())
            {
              
            	serv.addAnimal(rs.getString("Nume"),rs.getInt("Varsta"),rs.getString("ZooKeeper"),1);
            }
            rs = stmt.executeQuery("select * from `Parrot` ");
            while (rs.next())
            {
              
            	serv.addAnimal(rs.getString("Nume"),rs.getInt("Varsta"),rs.getString("ZooKeeper"),2);
            }
            rs = stmt.executeQuery("select * from `Lion` ");
            while (rs.next())
            {
              
            	serv.addAnimal(rs.getString("Nume"),rs.getInt("Varsta"),rs.getString("ZooKeeper"),3);
            }
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
		
	}
	public static void WriteToSQL(Service serv)
	{
		 Connection conn = null;
	        try {
	        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");

	            Statement stmt = null;
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from `angajati`");
	            List<Employee> e = serv.getList();
	    		int j = 0;
	    		int ok = 1;
	    		for (int i = 0; i < e.size(); i++) {
	    			ok = 1;
	    			//data += e.get(i).GetName() + ";" + e.get(i).GetAge() + ";" +
	                //        e.get(i).GetJob() + ";" + e.get(i).GetNrAnimals() + "\n";
	    			//1-ZooKeeper, 2-Vet, 3-AuxiliaryEmployee
	    			//System.out.println("INSERT INTO Parrot (Nume,Varsta,ZooKeeper) VALUES ('"+e.get(i).GetName()+"',"+ e.get(i).GetAge() + "," +e.get(i).GetJob()+ "," + e.get(i).GetNrAnimals()+ ");");
	    			rs = stmt.executeQuery("select * from `angajati`");
	    			//System.out.println(e.get(i).GetName());
	                while (rs.next())
	                {
	                
	                	if(e.get(j).GetName().equals(rs.getString("Nume")))
	                		{
	                			ok = 0;
	                			//System.out.println(e.get(i).GetName());
	                			break;
	                		}
	                }
	    			if(ok == 1)
	    				stmt.executeUpdate("INSERT INTO Angajati (Nume,Varsta,Functie,NumarAnimale) VALUES ('"+e.get(i).GetName()+"',"+ e.get(i).GetAge() + "," +e.get(i).GetJob()+ "," + e.get(i).GetNrAnimals()+ ");");
	    		}
	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }  
	}
}
