package textExcel;
//Nathan Tang 2nd period

public class SpreadsheetLocation implements Location{
    private int row;
    private int col;
	@Override
    public int getRow(){
        return row;
    }

    @Override
    public int getCol(){
        return col;
    }
    
    public SpreadsheetLocation(String cellName){
    	col=Character.toUpperCase(cellName.charAt(0))-'A';
    	row=Integer.parseInt(cellName.substring(1))-1;
    }

}
