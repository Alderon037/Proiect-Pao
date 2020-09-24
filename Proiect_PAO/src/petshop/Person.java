package petshop;

public class Person {
	int age;
	String name;
	public Person (String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public void Info() {
		System.out.println("Nume: " + this.name);
		System.out.println("Varsta: " + this.age);
	}
	public String GetN() {
		return name;
	}
	public int GetA() {
		return age;
	}
	public String InfoS() {
		return name + " " + Integer.toString(age);
	}
}
