package petshop;
import java.util.*; 

import java.text.SimpleDateFormat;
import java.io.*; 
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
class Sortbyroll implements Comparator<Employee> 
{ 

    public int compare(Employee a, Employee b) 
    { 
        int l1 = a.GetName().length(); 
        int l2 = b.GetName().length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)a.GetName().charAt(i); 
            int str2_ch = (int)a.GetName().charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        
        else { 
            return 0; 
        } 
    } 
} 

public class Service {
	String dataAudit = "";
    List<Employee> e = new ArrayList<Employee>(); 
    ServiceAudir sa = new ServiceAudir();
    String guiMessage="";
    String user = "";
	public void Request (int i, int gui)
	{
		Connection conn = null;
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");

            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `auditthreadfinal`");

                //stmt.executeUpdate("INSERT INTO Angajati (Nume,Varsta,Functie,NumarAnimale) VALUES ('"+e.get(i).GetName()+"',"+ e.get(i).GetAge() + "," +e.get(i).GetJob()+ "," + e.get(i).GetNrAnimals()+ ");");
    		
        
		Scanner scanner = new Scanner(System. in);
		if(i == 1) {
			System.out.println("Introduceti numele noului angajat:");
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Introducerea_unui_nou_angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			//dataAudit +=  "Introducerea unui nou angajat ; " + date + ";"+Thread.currentThread().getName() + "\n";
	        String inputString = scanner.nextLine();
	        System.out.println("Introduceti functia noului angajat(1-ZooKeeper, 2-Vet, 3-AuxiliaryEmployee):");
	        int job = scanner.nextInt();
	        System.out.println("Introduceti varsta noului angajat:");
	        int age = scanner.nextInt();
	        stmt.executeUpdate("INSERT INTO employees (Nume,Functie,Varsta) VALUES ('"+ inputString +"',"+job+","+age + ");"  );
	        if(job == 1) {
	        	ZooKeeper a = new ZooKeeper(inputString, age, 0);
	        	e.add(a);
	        	//e.get(0).Info(); 
	        }
	        if(job == 2) {
	        	Vet a = new Vet(inputString, age);
	        	e.add(a);
	        	//e.get(0).Info(); 
	        	//
	        }
	        if(job == 3) {
	        	AuxiliaryEmployees a = new AuxiliaryEmployees(inputString, age);
	        	e.add(a);
	        	//e.get(0).Info(); 
	        }
	        Collections.sort(e, new Sortbyroll()); 
		}else if(i == 5) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Introducerea_unui_nou_angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
		    dataAudit +=  "Introducerea unui nou angajat ; " + date + ";"+Thread.currentThread().getName() + "\n";
            System.out.println(dataAudit);
		    for(int j=0; j<e.size();j++)  
            {  
            	if(gui == 0)
            		e.get(j).Info();
            	else guiMessage = guiMessage + e.get(j).InfoS() + "<br>";
            }  
        }else if(i == 2) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String inputName;
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Cautarea unui angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Cautarea unui angajat ; " + date + "\n";
			if(gui == 0)
        	{
				System.out.println("Introduceti numele angajatului pe care il cautati:");
				inputName = scanner.nextLine();
			}else {
				inputName = user;
			}
            for(int j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			if(gui == 0)
            				e.get(j).DetInfo(); 
            			else guiMessage = e.get(j).InfoS();
            			break;
            		}
            	}
            }
         
        }else if(i == 9) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Adaugarea unui animal in grija unui angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Adaugarea unui animal in grija unui angajat ; " + date + "\n";
        	System.out.println("Introduceti numele angajatului in grija caruia vreti sa adaugati un animal:");
        	String inputName = scanner.nextLine();
        	int j;
            for( j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            System.out.println("Introduceti ce fel de animal(Monkey, Parrot, Lion) vreti sa adaugati in grija angajatului:");
        	String inputAnimal = scanner.nextLine();
        	if(inputAnimal.contentEquals("Monkey"))
        	{
        		System.out.println("Introduceti numele maimutei: ");
        		String inputNameA = scanner.nextLine();
        		System.out.println("Introduceti varsta: ");
        		int ageA = scanner.nextInt();
        		Animal an = new Monkey(inputNameA,ageA,"banana");
        		e.get(j).AddAnimal(an);
        	}
        	if(inputAnimal.contentEquals("Parrot"))
        	{
        		System.out.println("Introduceti numele papagalului: ");
        		String inputNameA = scanner.nextLine();
        		System.out.println("Introduceti varsta: ");
        		int ageA = scanner.nextInt();
        		Animal an = new Parrot(inputNameA,ageA,"seminte");
        		e.get(j).AddAnimal(an);
        	}
        	if(inputAnimal.contentEquals("Lion"))
        	{
        		System.out.println("Introduceti numele leului: ");
        		String inputNameA = scanner.nextLine();
        		System.out.println("Introduceti varsta: ");
        		int ageA = scanner.nextInt();
        		Animal an = new Lion(inputNameA,ageA,"carne");
        		e.get(j).AddAnimal(an);
        	}
        }if(i == 3) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String inputName;
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Afisarea informatiilor despre un angajat ','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Afisarea informatiilor despre un angajat ; " + date + "\n";
			if(gui == 0) {
				System.out.println("Introduceti numele angajatului ale carui animale vreti sa le afisati:");
        		inputName = scanner.nextLine();
			}else {
				inputName = user;
			}
        	int j;
            for( j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            if(gui == 0) {
            	e.get(j).PrintAnimal(); 
            }else {
            	guiMessage = e.get(j).PrintAnimalS(); 
            }
        }if(i == 4) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String inputName;
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Concedierea unui angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
		    
		    dataAudit +=  "Concedierea unui angajat ; " + date + "\n";
			if(gui == 0) {
				System.out.println("Introduceti numele angajatului pe care vreti sa-l concediati:");
				inputName = scanner.nextLine();
			}else {
				inputName = user;
			}
			stmt.executeUpdate("DELETE FROM employees WHERE nume = '"+ inputName+"';");
        	int j;
           	
        	
            for( j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            e.remove(j);
        }if(i == 6) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Salariul unui angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Salariul unui angajat ; " + date + "\n";
            for(int j=0; j<e.size();j++)  
            {  
            	System.out.println("Nume: " + e.get(j).GetName());
            	System.out.println("Salariu: " + e.get(j).SalaryCalculator());
            }
        }if(i == 7) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Mutarea unui animal din grija unui angajat','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Mutarea unui animal din grija unui angajat ; " + date + "\n";
        	System.out.println("Introduceti numele angajatului de la care vreti sa mutati animalul: ");
        	String inputName1 = scanner.nextLine();
        	System.out.println("Introduceti numele angajatului la care vreti sa mutati animalul: ");
        	String inputName2 = scanner.nextLine();
        	int j,k;
            for(j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName1)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
        	
            for(k=0; k<e.size();k++)  
            {  
            	if((e.get(k).GetName()).equals(inputName2)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            System.out.println("Introduceti numele animalului ce trebuie mutat: ");
            String AName = scanner.nextLine();

            String food = e.get(j).RetFood(AName);
            int age = e.get(j).RetAge(AName);
            if(food.equals("banana"))
            {
        		Animal an = new Monkey(AName,age,"banana");
        		e.get(k).AddAnimal(an);
            }else if(food.equals("seminte")){
        		Animal an = new Parrot(AName,age,"seminte");
        		e.get(k).AddAnimal(an);
            }else {
            	Animal an = new Lion(AName,age,"carne");
        		e.get(k).AddAnimal(an);
            }
            e.get(j).DeleteAnimal(AName);
           
            
        }if(i == 8) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Stergerea unui animal','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			dataAudit +=  "Stergerea unui animal ; " + date + "\n";
        	System.out.println("Introduceti numele angajatului de la care vreti stergeti animalul: ");
        	String inputName = scanner.nextLine();
        	int j;
            for(j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            System.out.println("Introduceti numele animalului pe care vreti sa-l stergeti: ");
        	String AName = scanner.nextLine();
        	e.get(j).DeleteAnimal(AName);
            
        }if(i == 10) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
		    String inputName;
		    String strDate = formatter.format(date); 
		    stmt.executeUpdate("INSERT INTO auditthreadfinal (Actiune,Ora,Thread) VALUES ('Interactiunea cu animalele','"+ strDate + "','" +Thread.currentThread().getName()+ "');");
			//dataAudit +=  "Interactiunea cu animalele ; " + date + "\n";
			if(gui == 0) {
				System.out.println("Introduceti numele angajatului cu ale carui animale vreti sa interactionati: ");
        		inputName = scanner.nextLine();}
			else {
				inputName = user;
			}
        	int j;
            for(j=0; j<e.size();j++)  
            {  
            	if((e.get(j).GetName()).equals(inputName)) {
            		{
            			//e.get(j).Info(); 
            			break;
            		}
            	}
            }
            if(gui == 0) {
            e.get(j).Interact();
            }else {
            	guiMessage = guiMessage + e.get(j).InteractS() + "<br>";
            }
            
        	}
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }  
	}
	public void addEmployee( String name, int type,  int age) {

        if(type == 1) {
        	ZooKeeper a = new ZooKeeper(name, age, 0);
        	e.add(a);
        	//e.get(0).Info(); 
        }
        if(type == 2) {
        	Vet a = new Vet(name, age);
        	e.add(a);
        	//e.get(0).Info(); 
        }
        if(type == 3) {
        	AuxiliaryEmployees a = new AuxiliaryEmployees(name, age);
        	e.add(a);
        	//e.get(0).Info(); 
        }
	}
	public void addAnimal( String name, int age, String zooKeeperName, int type) {

    	int j;
        for( j=0; j<e.size();j++)  
        {  
        	if((e.get(j).GetName()).equals(zooKeeperName)) {
        		{
        			//e.get(j).Info(); 
        			break;
        		}
        	}
        }
        if(type == 1) {
    		Animal an = new Monkey(name, age, "banana");
    		e.get(j).AddAnimal(an); 
    		//System.out.println(name + " " + age + " banana");
        }
        if(type == 2) {
    		Animal an = new Parrot(name, age, "seminte");
    		e.get(j).AddAnimal(an); 
        }
        if(type == 3) {
    		Animal an = new Lion(name, age, "carne");
    		e.get(j).AddAnimal(an); 
        }
	}
	public List<Employee> getList(){
		return e;
	}
	public void callAudit() {
		
		sa.WriteToAudit(dataAudit);
	}
	public String GetGUIMessage() {
		return guiMessage;
	}
	public void EmptyGUIMessage() {
		guiMessage = "";
	}
	public void SetUser(String u) {
		user = u;
	}
}

