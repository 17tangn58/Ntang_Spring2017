
public class AdvanceTicket extends Ticket {
	private int daysB4Event;
	public AdvanceTicket(int n, int days){
		super(n);
		days=daysB4Event;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if(daysB4Event<=10)
			return 30.0;
		else 
			return 40.0;
	}
	
	public int getDays(){
		return daysB4Event;
	}
}