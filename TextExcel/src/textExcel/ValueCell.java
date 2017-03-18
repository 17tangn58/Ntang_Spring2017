package textExcel;

public class ValueCell extends RealCell{
	private double decimal;
	public ValueCell(String value) {
		super(value);
		decimal=Double.parseDouble(value);
	}
	public String fullCellText(){
		return getString();
	}
	public String abbreviatedCellText(){
		String num = getString();
		/*if (decimal*10/10==decimal)
			num= num+".0";*/
		if(getString().length()>10){
				return num.substring(0, 10);
		}	
		else
			return String.format("%-10s", num.substring(0));
	}
	public double getDoubleValue(){
		if(getString().substring(0, 1).equals("-"))
			return decimal*-1.0;
		return decimal;
	}
	
}