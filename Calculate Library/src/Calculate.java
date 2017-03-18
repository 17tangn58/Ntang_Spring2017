/**
 * 
 */

/**
 * @author Nathan Tang 9/19/16
 * Calculate Library
 */
public class Calculate {

	public static int square(int number) {
		//This method will square a number by multiplying it by itself
		return (number * number);
	}
	
	public static int cube(int number) {
		//This method will cube a number by multiplying it by itself twice
		return (number * number * number);
	
	}
	
	public static double average(double num1, double num2) {
		//This method calculates the average between two numbers by adding them and later dividing by 2
		return ((num1 + num2) / 2);
	}
	
	public static double average(double num1, double num2, double num3) {
		//This method calculates the average between three numbers by adding them and later dividing by 3 
		return ((num1 + num2 + num3)/ 3);
	}
	
	public static double toDegrees(double number) {
		//This method changes from radians to degrees using the conversion factor
		return (number * 180/3.14159);
	}
	
	public static double toRadians(double number) {
		//This method changes a number from degrees to radians using the conversion factor
		return(number * 3.14159/180);
	}
	
	public static double discriminant(double a, double b, double c) {
		//This method finds part of the quadratic equation
		return((b*b)-4*a*c);
	}
	
	public static String toImproperFrac(int num1, int num2, int num3) {
		//This method makes a mixed number an improper fraction
		int answer = num1 * num3+ num2;
		return(answer + "/" + num3);
	}
	
	public static String toMixedNum(int num1, int num2) {
		//This method makes an improper fraction a mixed number
		int numerator = num1/num2;
		int b = num1%num2;
		return(numerator+"_"+b+"/"+num2);
	}
	
	public static String foil(int num1, int num2, int num3, int num4, String s) {
		//This method multiplies two binomials and puts the values into an equation
		int a=num1*num3;
		int b = num1*num4+(num2*num3);
		int c = num2*num4;
		return(a + s + "^2" + "+" + b + s + "+" + c);
	}
	
	public static boolean isDivisibleBy(int num1, int num2) {
		//This method tells the user whether one number divided by another results in a whole number
		if (num2==0) throw new IllegalArgumentException("Nothing is divisible by zero");
		if (num1%num2==0)
			return(true);
		else;
			return(false); 
	}
	
	public static double absValue(double num) {
		//This method returns the absolute value(the distance from a number to zero) of a number
		if(num>=0)
			return(num);
		else;
			return(num*-1);
	}
	public static int max(int num1, int num2) {
		//This method returns the largest of two numbers
		if(num1>num2)
			return(num1);
		else;
			return(num2);
	}
	public static double max(double num1, double num2, double num3) {
		//This method returns the largest number out of three choices
		if(num1>num2&&num1>num3)
			return(num1);
		if(num2>num1&&num2>num3)
			return(num2);
		else;
			return(num3);
	}
	public static int min(int num1, int num2) {
		//This method returns the smaller num
		if (num1<num2)
			return(num1);
		else;
			return(num2);
	}
	public static double round2(double num) {
		//This method rounds a number to two decimal places
		int b = (int)(num*100);
		double answer=1;
		if (100*num-b>=.5){
			if(num<0){
				answer=b-1;
			}
			else
				answer = (b+1);
		}
		else {
			answer = (b);
		}	
		return answer/100;
	}
	public static double exponent(double num, int exp){
		//This method will multiply one number the amount of times the second number equals
		if (exp<0) throw new IllegalArgumentException("This method does not work with negative exponents");
		double ans=1;
		double num2=1.0;
		for(int i=1;i <= exp; i++){
			ans= num2*num;
			num2=ans;
		}
		return(ans);			
	}
	public static int factorial(int num){
		//This method will find a factorial, a value  usually in the form x! that multiplies a number by every number less than it
		if (num<0) throw new IllegalArgumentException("This factorial method does not work with negatives");
		int ans=1;
		int product=1;
		for(int i=1;i<=num; i++){
			ans=product*i;
			product=ans;
		}
		return ans;
	}
	public static boolean isPrime(int num){
		//This method calculates whether a number is prime by finding if it is divisible by any number smaller than it
		boolean result=false;
		for(int i=num-1;i<1;i--){
			if(Calculate.isDivisibleBy(num, i)==true)
				result= false;
			else{
				result=true;
			}
		}
		return result;
	}
	public static int gcf(int num1, int num2){
		/*This method finds the greatest common factor between two numbers using a loop to calculate whether those two numbers are
		divisible by another number
		*/
		int ans= 1;
		for(int i=1; i<=num1 || i<=num2; i++){
			if (Calculate.isDivisibleBy(num1, i) || Calculate.isDivisibleBy(num2, i)) {
				ans= i;
			}
		}
		return ans;
	}
	public static double sqrt(double num) {
		//This method will find the square root of a number.
		if (num<0) throw new IllegalArgumentException("Negative square roots result in imaginary numbers");
		double x=1.0;
		double ans=num/2;
		if (num==0){
			return 0;
		}
		else{
			do{
				x=ans;
				ans=(x+(num/x))/2;
			}
			while((x-ans)!=0); 
				return Calculate.round2(ans);
		}
	}
	public static String quadForm(int a, int b, int c){
		//This method uses the quadratic formula to solve the quadratic equation
		double discriminant = Calculate.discriminant((double)(a), (double)(b), (double)(c));
		if (discriminant<0)
			return ("no real roots");
		double sqrt = Calculate.sqrt(discriminant);
		double ans1=((-b+sqrt)/2/(a));
		double ans2=((-b-sqrt)/2/(a));
		ans1=Calculate.round2(ans1);
		ans2=Calculate.round2(ans2);
		if (ans1>ans2){
			return (ans2+" and "+ans1);
		}
		else
			return (ans1+" and "+ans2);
	}
}

