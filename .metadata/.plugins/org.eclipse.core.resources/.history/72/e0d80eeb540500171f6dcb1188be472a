package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String line){
		text=line;
	}
	@Override
	public String abbreviatedCellText() {
		if(text.length()>10)
			return text.substring(0,10);
		else{
			text=String.format("%-10s", text);
			return text;
		}
	}
	@Override
	public String fullCellText() {
		return text;
	}

}
