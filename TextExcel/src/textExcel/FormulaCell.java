package textExcel;
public class FormulaCell extends RealCell {
	private double ans;
	public FormulaCell(String value, Cell[][] spr) {
		//for now only stores original string
		super(value);
	}
	public String fullCellText(){
		//Returns formula
		return getString();
	}
	public String abbreviatedCellText(){
		//returns answer of the formula as a string
		return (getDoubleValue()+"                     ").substring(0, 10);
	}
	public double getDoubleValue(){
		//returns the answer to the formula as a double
		String[] split = getString().split(" ");
		double[] formula = new double[split.length/2];
		for(int i=0;i<formula.length;i++){
			if(Character.isLetter(split[i].charAt(0))){
				SpreadsheetLocation loc = new SpreadsheetLocation(split[i]);
				
			}
		}
		double answer=formula[0];
		for(int i=0;i<split.length;i++){
			answer+=calculate(answer, formula[i+1], split[i]);
		}
		return answer;
	}	
	public double calculate(double a, double b, String operation){
		if(operation.equals("+"))
			a += b;
		else if(operation.equals("/"))
			a /= b;
		else if(operation.equals("*"))
			a *= b;
		else if(operation.equals("-"))
			a -= b;
		return a;
	}
}
