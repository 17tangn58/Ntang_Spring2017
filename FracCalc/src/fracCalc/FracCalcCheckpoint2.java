/* Nathan Tang
 * 
 * 2nd period
 */
package fracCalc;
import java.util.*;
public class FracCalcCheckpoint2 {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput=new Scanner(System.in);
    	System.out.println("Please type your problem");
    	String equation=userInput.nextLine();
    	while(equation!="quit"){
    		System.out.println(produceAnswer(equation));
    		equation=userInput.nextLine();
    	}
    	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
        // TODO: Implement this function to produce the solution to the input
        String[] operands=input.split(" ");
		String[] parts1=parse(operands[0]);
        String[] parts2=parse(operands[2]);
        return "whole:"+parts2[0]+" numerator:"+parts2[1]+" denominator:"+parts2[2];
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String[] parse(String operand){
    	String[] findWhole = operand.split("_");
    	String[] fraction = findWhole[findWhole.length-1].split("/");
    	String[] operandParts = new String[3];
    	if(operand.indexOf("_")<0&&operand.indexOf("/")>=0){
    		operandParts[0]="0";
    	}
    	else {
    		operandParts[0]=findWhole[0];
    	}
    	if(operand.indexOf("/")<0){
    		operandParts[1]="0";
    		operandParts[2]="1";
    	}
    	else {
    		operandParts[1]=fraction[0];
    		operandParts[2]=fraction[1];
    	}
    	return operandParts;
    }
}

