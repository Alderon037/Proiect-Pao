package petshop;

public class Employee extends Person {
	float baseSalary = 1000;
	float salary;
	public Employee (String name, int age) {
		super(name, age); 
	}
	
	public float SalaryCalculator() {

		return baseSalary;
	}
	
	public float GetSalary() {
		return baseSalary;
	}
	
	public void SetSalary(float salary) {
		this.salary = salary;
	}
	
	public void Info() {
		super.Info();
	}
	public void DetInfo() {
		super.Info();
		
	}
	public String GetName() {
		String s = super.GetN();
		return s;
	}
	public int GetAge() {
		int s = super.GetA();
		return s;
	}
	public int GetJob() {
		return 0;
	}
	public void AddAnimal(Animal an) {
		System.out.println("This person is not a zookeeper");
	}
	public void PrintAnimal() {
		System.out.println("This person is not a zookeeper");
	}
	public String RetFood(String s) {
		System.out.println("This person is not a zookeeper");
		return "";
	}
	public int RetAge(String s) {
		System.out.println("This person is not a zookeeper");
		return 0;
	}
	public void DeleteAnimal(String s) {
		System.out.println("This person is not a zookeeper");
	}
	public void Interact() {
		System.out.println("This person is not a zookeeper");
	}
	public String InteractS() {
		return "";
	}
	public int GetNrAnimals() {
		return 0;
	}
	public String InfoS() {
		return super.InfoS() + "<br> \n";
	}
	public String PrintAnimalS() {
		
		return "";
	}
}
