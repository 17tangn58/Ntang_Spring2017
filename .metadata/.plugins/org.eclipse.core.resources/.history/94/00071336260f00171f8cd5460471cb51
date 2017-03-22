package textExcel;
/*Nathan Tang 
 * 2nd period
 * 3/19/17
 */
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class TextExcel{
	public static void main(String[] args) throws FileNotFoundException{
		//construction of spreadsheet and scanning for commands
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner userInput=new Scanner(System.in);
		System.out.println("Please enter a command");
		String command=userInput.nextLine();
		while(!command.equals("quit")){ //Command loop
			System.out.println(spreadsheet.processCommand(command));
			System.out.println("Please enter another command");
			command=userInput.nextLine();
		}
	}

}
