package petshop;

public class Animal {
	String name;
	int age;
	String food;
	Boolean feed;
	public Animal(String name, int age, String food)
	{
		this.name = name;
		this.age = age;
		this.food = food;
	}
	public void Info() {
		System.out.println("Nume animal: " + name);
		System.out.println("Varsta animal: " + age);
		System.out.println("Mancare: " + food);
	}
	public String InfoS() {
		return "<br>Nume animal: " + name + " Varsta animal: " + Integer.toString(age) + " Mancare: " + food;
	}
	public String InteractionS() {
		return "";
		
	}
	public String GetName() {
		return name;
	}
	public String GetFood() {
		return food;
	}
	public int GetAge() {
		return age;
	}
	public void Interaction() {
		System.out.println("Animalul doarme");
	}
}
