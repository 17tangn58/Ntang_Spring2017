package textExcel;
//Nathan Tang 2nd period
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class TextExcel{
	public static void main(String[] args) throws FileNotFoundException{
		String s =Double.parseDouble("0.01021822")*100.0+"";
		System.out.println(s);
		PercentCell p = new PercentCell("1.021822");
		System.out.println(p.abbreviatedCellText());
		/*Spreadsheet spreadsheet = new Spreadsheet();
		Scanner userInput=new Scanner(System.in);
		System.out.println("Please enter a command");
		String command=userInput.nextLine();
		while(!command.equals("quit")){ //Command loop
			System.out.println(spreadsheet.processCommand(command));
			System.out.println("Please enter another command");
			command=userInput.nextLine();
		}*/
	}

}
