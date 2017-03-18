
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket(int n, int days){
		super(n, days);
	}
	public double getPrice(){
		return super.getPrice()/2.0;
	}
	public String toString(){
		return super.toString()+" (ID required)"; 
	}
}