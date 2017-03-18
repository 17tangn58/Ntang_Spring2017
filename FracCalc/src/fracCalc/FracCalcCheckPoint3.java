/* Nathan Tang
 * 12/9/16
 * 2nd period
 */
package fracCalc;
import java.util.*;
public class FracCalcCheckPoint3 {
	public static void main(String[] args) {
		// Reads the input from the user and call produceAnswer with an equation
		Scanner userInput=new Scanner(System.in); 
		System.out.println("Please type your problem");
		String equation=userInput.nextLine();
		while(equation.equals("quit")==false){
			if(equation.indexOf("quit")<=0)
				System.out.println(produceAnswer(equation));
			System.out.println("Please type another problem or quit if you want to stop");
			equation=userInput.nextLine();
		}
	}
	public static String produceAnswer(String input){ 
		// Produces the solution to the input
		String[] expressionParts=parseInput(input);
		int[] parts1=parseOperands(expressionParts[0]);
		int[] parts2=parseOperands(expressionParts[2]);
		int[] answer= new int[2];
		if(expressionParts[1].equals("+")){
			answer=addFrac(parts1, parts2);
		}
		else if(expressionParts[1].equals("-"))
			answer=subtractFrac(parts1, parts2);
		else if(expressionParts[1].equals("*"))
			answer=multiplyFrac(parts1, parts2);
		else
			answer=divideFrac(parts1, parts2);
		return answer[0]+"/"+answer[1];
	}
	public static String[] parseInput(String expression){
		//Parses the input into its parts
		String[] parts = expression.split(" ");
		return parts;
	}
	public static int[] parseOperands(String operand){
		//Parses one of the operators, returning it as an improper fraction
		String[] findWhole = operand.split("_");
		String[] fraction = findWhole[findWhole.length-1].split("/");
		String[] operandParts = new String[3];
		operandParts[2]="1";
		int[] operandInt = new int[3];
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
		for(int i=0;i<operandParts.length;i++){
			operandInt[i]=Integer.parseInt(operandParts[i]);
		}
		if(operandInt[0]<0)
			operandInt[1]=operandInt[1]*-1;
		int[] improperFrac = toImproperFrac(operandInt[0], operandInt[1], operandInt[2]);
		return improperFrac;
	}
	public static int[] toImproperFrac(int num1, int num2, int num3) {
		//This method makes a mixed number an improper fraction in array form
		int[] toImproperFrac=new int[2];
		toImproperFrac[0] = num1 * num3 + num2;
		toImproperFrac[1] = num3;
		return toImproperFrac;
	}
	public static int[] addFrac(int[] operand1, int[] operand2){
		//Adds two improper fractions
		int[] ans = new int[2];
		int commonDenom = operand1[1]*operand2[1];
		operand1[0] = operand1[0]*operand2[1];
		operand2[0] = operand1[1]*operand2[0];
		int finalNumerator = operand1[0]+operand2[0];
		ans[0]=finalNumerator;
		ans[1]=commonDenom;
		return ans;
	}
	public static int[] subtractFrac(int[] operand1, int[] operand2){
		//Subtracts the second improper fraction from the first
		operand2[0]=operand2[0]*(-1);
		int[] ans = addFrac(operand1, operand2);
		return ans;
	}
	public static int[] multiplyFrac(int[] operand1, int[] operand2){
		//Multiplies two improper fractions
		int[] ans = new int[2];
		ans[0]= operand1[0]*operand2[0];
		ans[1] = operand1[1]*operand2[1];
		return ans;
	}
	public static int[] divideFrac(int[] operand1, int[] operand2){
		//Divides the second improper fraction from the first
		int[] newOperand = new int[2];
		newOperand[0]=operand2[1];
		newOperand[1]=operand2[0];
		int[] ans = multiplyFrac(operand1, newOperand);
		return ans;
	}
}