/* Nathan Tang
 * 12/9/16
 * 2nd period
 * Fraction Calculator
 */
package fracCalc;
import java.util.*;
public class FracCalc {
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
		String simpAns = simplifyFrac(answer);
		return simpAns;
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
	public static String simplifyFrac(int[] fraction){
		//Simplifies the answer fraction to its most reduced form(mixed number or a reduced fraction)
		int[] mixedNum = new int[3];
		mixedNum[0]=fraction[0]/fraction[1];
		mixedNum[1]=fraction[0]%fraction[1];
		mixedNum[2]=fraction[1];			
		if(mixedNum[1]==0)
			return mixedNum[0]+"";
		
		else{
			int commonDenom=gcf(mixedNum[1], mixedNum[2]);
			if(mixedNum[1]<0&&mixedNum[0]<0)
				mixedNum[1]=Math.abs(mixedNum[1]/commonDenom);
			else
				mixedNum[1]=(mixedNum[1]/commonDenom);
			if(mixedNum[0]<0&&mixedNum[1]<0||mixedNum[1]>0&&mixedNum[0]==0&&commonDenom<0)
				mixedNum[1]=mixedNum[1]*-1;
			mixedNum[2]=Math.abs(mixedNum[2]/commonDenom);
			if(mixedNum[0]==0&&mixedNum[1]!=0)
				return mixedNum[1]+"/"+mixedNum[2];
			return mixedNum[0]+"_"+mixedNum[1]+"/"+mixedNum[2];
		}
	}
	public static int gcf(int num1, int num2){
		/*This method finds the greatest common factor between two numbers using a loop to calculate whether those two numbers are
			divisible by another number
		 */
		int ans= 1;
		if(num1>0&&num2>0){
			for(int i=1; i<=num1 || i<=num2; i++){
				if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
					ans= i;
				}
			}
		}
		else{
			for(int i=-1;i>=num1 || i>=num2; i--){
				if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
					ans= i;
				}
			}
		}
		return ans;
	}
	public static boolean isDivisibleBy(int num1, int num2) {
		//This method tells the user whether one number divided by another results in a whole number
		if (num1%num2==0)
			return(true);
		else;
		return(false); 
	}
}
