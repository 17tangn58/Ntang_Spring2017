package textExcel;

public class PercentCell extends ValueCell {
	private double percent;
	public PercentCell(String value){
			super(value);
			percent=Double.parseDouble(value.substring(0, value.length()-1));
	}
	public String fullCellText(){
		return ""+percent/100;
	}
	public String abbreviatedCellText(){
		int b = (int)(percent*10/10);
		if (percent-b>=.5){
			if(percent<0)
				percent=b-1;
			else
				percent = (b+1);
		}
		else
			percent = (b);
		return String.format("%-10s", b+"%");
	}
	public double getDoubleValue(){
		return percent/100;
	}
	
}
