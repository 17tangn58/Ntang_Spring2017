import java.io.*;
import java.util.*;
public class WeatherChange {
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner input=new Scanner(new File("./data/weather.txt"));
		double previous = input.nextDouble();
		double current;
		while(input.hasNext()){
			current = input.nextDouble();
			double diff = current-previous;
			double temp=diff*100.0;
			double rounded=(int)temp/100.0;
			System.out.println(previous+" to "+current+", change = "+rounded);
			previous=current;
		}
	}
}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				