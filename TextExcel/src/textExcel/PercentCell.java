package textExcel;

public class PercentCell extends ValueCell {
	private double percent;
	public PercentCell(String value){
			super(value);
			percent=Double.parseDouble(value);
	}
	public String fullCellText(){
		//returns percentage as a decimal
		return ""+percent/100;
	}
	public String abbreviatedCellText(){
		//truncates the percentage
		int b=periodLoc();
		return String.format("%-10s", getString().substring(0, b)+"%");
	}
	public double getDoubleValue(){
		return percent/100;
	}
	
}
