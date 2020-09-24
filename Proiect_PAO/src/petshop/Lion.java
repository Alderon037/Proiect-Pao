package petshop;

public class Lion extends Animal{
	int b = 0;
	public Lion(String name, int age, String food) {
		super(name,age,food);
	}
	@Override
	public void Info() {
		System.out.println("Leu");
		super.Info();
	}
	@Override
	public String InfoS() {
		
		return super.InfoS() + "<br> Specie: Leu";
	}
	@Override
	public void Interaction() {
		b++;
		if(b <=3 ) {
		System.out.println("Leul a inceput sa raga");
		}else {
			System.out.println("Leul a ragusit");
		}
		
	}
	@Override
	public String InteractionS() {
		b++;
		if(b <=3 ) {
		return "Leul a inceput sa raga";
		}else {
			return "Leul a ragusit";
		}
		
	}
}
