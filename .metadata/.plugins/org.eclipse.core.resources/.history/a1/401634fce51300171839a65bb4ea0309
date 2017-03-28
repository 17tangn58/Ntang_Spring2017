package textExcel;
/*Nathan Tang 
 * 2nd period
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class Spreadsheet implements Grid{
	Cell[][] sprSheet=new Cell[20][12];
	public Spreadsheet(){
		//Creates spreadsheet by initializing a 20 row 12 column sheet with empty cells
		for(int i=0;i<sprSheet.length;i++){
			for(int j=0;j<sprSheet[i].length;j++)
				sprSheet[i][j]=new EmptyCell();
		}

	}
	@Override
	public String processCommand(String command){
		String[] commandParts = command.split(" ", 3);
		if(commandParts[0].toLowerCase().equals("save"))
			return writeToFile(commandParts[1]);
		if(commandParts[0].toLowerCase().equals("open"))
			return readFile(commandParts[1]);
		if(commandParts.length==1&&commandParts[0].toLowerCase().equals("clear"))
			//calls method that clears spreadsheet
			return clear();
		SpreadsheetLocation loc;
		if(commandParts.length==1&&!commandParts[0].equals("clear")&&!commandParts[0].equals("")){
			//inspection of cell
			loc=new SpreadsheetLocation(commandParts[0]);
			return getCell(loc).fullCellText();
		}
		else if(commandParts.length>1&&commandParts[1].equals("=")){
			//constructing the correct cell type
			loc=new SpreadsheetLocation(commandParts[0]);
			if(commandParts[2].substring(0,1).equals("\""))
				sprSheet[loc.getRow()][loc.getCol()]= new TextCell(commandParts[2]);
			else if(commandParts[2].substring(commandParts[2].length()-1).equals("%"))
				sprSheet[loc.getRow()][loc.getCol()]= new PercentCell(commandParts[2].substring(0, commandParts[2].length()-1));
			else if(commandParts[2].substring(0,1).equals("("))
				sprSheet[loc.getRow()][loc.getCol()]= new FormulaCell(commandParts[2], this.sprSheet);
			else
				sprSheet[loc.getRow()][loc.getCol()]= new ValueCell(commandParts[2]);
			return getGridText();
		}
		else if(commandParts[0].toLowerCase().equals("clear")){
			//clears a single cell
			loc =new SpreadsheetLocation(commandParts[1]);
			sprSheet[loc.getRow()][loc.getCol()]=new EmptyCell();
			return getGridText();
		}
		return "";
	}
	
	public int getRows(){
		//number of columns(1->20) is 20
		return 20;
	}

	
	public int getCols(){
		//number of columns(A->L) is 12
		return 12;
	}

	
	public Cell getCell(Location loc){
		//returns the cell at that location
		return sprSheet[loc.getRow()][loc.getCol()];
	}

	
	public String getGridText(){
		//constructs the spreadsheet
		String s="   |";
		for(int i=0;i<12;i++){
			s+=(char)('A' + i)+"         |";
		}
		s+="\n";
		for(int i=0;i<this.getRows();i++){
			s+=String.format("%-3d|", i+1);
			for(int j=0;j<this.getCols();j++){
				char row=(char) (j+'A');
				int col=i+1;
				String loc=row+""+col;
				SpreadsheetLocation cellLoc=new SpreadsheetLocation(loc);
				s+=getCell(cellLoc).abbreviatedCellText()+"|";
			}
			s+="\n";
		}
		return s;
	}
	public String clear(){
		//clears spreadsheet by making everything empty cells
		for(int i=0;i<sprSheet.length;i++){
			for(int j=0;j<sprSheet[i].length;j++)
				sprSheet[i][j]=new EmptyCell();
		}
		return getGridText();
	}
	private String writeToFile (String filename){
		PrintStream outputFile;
		try {
			outputFile = new PrintStream(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		String enter="";
		//for loop that checks all cells to return location, type, values stored in each
		for(int i=0;i<20;i++){
			for(char j='A';j<'M';j++){
				Cell test=sprSheet[i][j-'A'];
				if(sprSheet[i][j-'A'] instanceof FormulaCell){
					enter+=j+""+(i+1)+",FormulaCell,"+test.fullCellText()+"\n";
				}
				if(sprSheet[i][j-'A'] instanceof TextCell){
					enter+=j+""+(i+1)+",TextCell,"+test.fullCellText()+"\n";
				}
				if(sprSheet[i][j-'A'] instanceof ValueCell){
					enter+=j+""+(i+1)+",ValueCell,"+test.fullCellText()+"\n";
				}
				if(sprSheet[i][j-'A'] instanceof PercentCell){
					enter+=j+""+(i+1)+",PercentCell,"+test.fullCellText()+"\n";
				}
			}	
		}
		outputFile.print(enter);
		outputFile.close();
		return "";
	}
	private String readFile(String filename){
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		while(inputFile.hasNextLine()){
			//Reads the input and decides which cell to construct
			String line=inputFile.nextLine();
			String[] lineParts = line.split(",");
			SpreadsheetLocation loc = new SpreadsheetLocation(lineParts[0]);
			if(lineParts[1].equals("ValueCell"))
				sprSheet[loc.getRow()][loc.getCol()]=new ValueCell(lineParts[2]);
			else if(lineParts[1].equals("TextCell"))
				sprSheet[loc.getRow()][loc.getCol()]=new TextCell(lineParts[2]);
			else if(lineParts[1].equals("FormulaCell"))
				sprSheet[loc.getRow()][loc.getCol()]=new TextCell(lineParts[2]);
			else if(lineParts[1].equals("PercentCell")){
				String percent = Double.parseDouble(lineParts[2])*100.0+"";
				sprSheet[loc.getRow()][loc.getCol()]=new PercentCell(percent);
			}
		}
		inputFile.close();
		return getGridText();
	}
}

