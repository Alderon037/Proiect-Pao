package petshop;

public class Monkey extends Animal{
	int b = 0;
	public Monkey(String name, int age, String food) {
		super(name,age,food);
	}
	
	@Override
	public void Info() {
		System.out.println("Maimutica");
		super.Info();
	}
	@Override
	public String InfoS() {
		
		return super.InfoS() + "<br> Specie: Maimuzzzza";
	}
	@Override
	public void Interaction() {
		b++;
		if(b <=3 ) {
		System.out.println("Maimutica a aruncat " + b +" banane spre tine");
		}else {
			System.out.println("Maimutica nu intelege de ce nu-i dai pace");
		}
		
	}
	@Override
	public String InteractionS() {
		b++;
		if(b <=3 ) {
		return "Maimutica a aruncat " + b +" banane spre tine";
		}else {
			return "Maimutica nu intelege de ce nu-i dai pace";
		}
		
	}
}
