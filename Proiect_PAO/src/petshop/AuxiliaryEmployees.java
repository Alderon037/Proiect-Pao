package petshop;

public class AuxiliaryEmployees extends Employee{
	
	public AuxiliaryEmployees (String name, int age) {
		super(name, age);
	}
	@Override
	public void Info() {
		super.Info();
		System.out.println("Job: Auxiliary Employee");
	}
	
	@Override
	public void DetInfo(){
		super.Info();
		
	}
	@Override
	public int GetJob() {
		return 3;
	}
	@Override
	public String InfoS() {
		return super.InfoS() + " Job: Auxiliary Employee <br>" + "\n";
	}
}
