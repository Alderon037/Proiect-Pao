package petshop;

public class Vet extends Employee{
	public Vet(String name, int age) {
		super(name, age);
	}
	@Override
    public float SalaryCalculator() 
    { 
        float salary = super.GetSalary();
        salary = salary + (25 * salary)/100;
        return(salary);
    }
	@Override
	public void Info() {
		super.Info();
		System.out.println("Job: Vet");
	}
	
	@Override
	public void DetInfo(){
		super.Info();
		
	}
	@Override
	public int GetJob() {
		return 2;
	}
	@Override
	public String InfoS() {
		return super.InfoS() + " Job: Vet <br>" + "\n";
	}
}
