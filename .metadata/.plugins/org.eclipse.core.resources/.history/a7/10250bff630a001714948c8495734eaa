package textExcel;

public class PercentCell extends ValueCell {
	private double percent;
	public PercentCell(String value){
			super(value);
			percent=Integer.parseInt(value.substring(1, value.length()-1));
	}
	public String fullCellText(){
		return ""+percent/100;
	}
	public String abbreviatedCellText(){
		return getString().substring(0,1)+"%";
	}
	public double getDoubleValue(){
		return percent/100;
	}
	
}
