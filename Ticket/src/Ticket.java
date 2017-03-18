
public abstract class Ticket {
	private int number;
	public abstract double getPrice();
	public String toString(){
		return "Number: "+number+", Price: "+getPrice(); 
	}
	public Ticket(int n){
		number=n;
	}
}
