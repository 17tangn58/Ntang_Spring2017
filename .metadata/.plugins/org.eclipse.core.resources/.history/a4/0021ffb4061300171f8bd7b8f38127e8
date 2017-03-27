package textExcel;

public class FormulaCell extends RealCell {
	private double ans;
	public FormulaCell(String value) {
		//for now only stores original string
		super(value);
	}
	public String fullCellText(){
		//Returns formula
		return getString();
	}
	public String abbreviatedCellText(){
		//returns answer of the formula as a string
		return String.format("%-10s", ""+getDoubleValue());
	}
	public double getDoubleValue(){
		//returns the answer to the formula as a double
		String[] formula = getString().split(" ");
		double answer=0.0;
		for(int i=0;i<formula.length;i++){
			if(formula[i].equals("+"))
				answer = Double.parseDouble(formula[i-1])+Double.parseDouble(formula[i+1]);
			else if(formula[i].equals("/"))
				answer = Double.parseDouble(formula[i-1])/Double.parseDouble(formula[i+1]);
			else if(formula[i].equals("*"))
				answer = Double.parseDouble(formula[i-1])*Double.parseDouble(formula[i+1]);
			else if(formula[i].equals("-"))
				answer = Double.parseDouble(formula[i-1])-Double.parseDouble(formula[i+1]);
		}
		return answer;
	}
	
}
