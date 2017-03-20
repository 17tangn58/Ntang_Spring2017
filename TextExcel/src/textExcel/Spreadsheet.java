package textExcel;
//Nathan Tang 2nd period
// Update this file with your own code.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class Spreadsheet implements Grid{
	Cell[][] sprSheet=new Cell[20][12];
	public Spreadsheet(){
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
			return clear();
		SpreadsheetLocation loc;
		if(commandParts.length==1&&!commandParts[0].equals("clear")&&!commandParts[0].equals("")){
			loc=new SpreadsheetLocation(commandParts[0]);
			return getCell(loc).fullCellText();
		}
		else if(commandParts.length>1&&commandParts[1].equals("=")){
			loc=new SpreadsheetLocation(commandParts[0]);
			if(commandParts[2].substring(0,1).equals("\""))
				sprSheet[loc.getRow()][loc.getCol()]= new TextCell(commandParts[2]);
			else if(commandParts[2].substring(commandParts[2].length()-1).equals("%"))
				sprSheet[loc.getRow()][loc.getCol()]= new PercentCell(commandParts[2].substring(0, commandParts[2].length()-1));
			else if(commandParts[2].substring(0,1).equals("("))
				sprSheet[loc.getRow()][loc.getCol()]= new FormulaCell(commandParts[2]);
			else
				sprSheet[loc.getRow()][loc.getCol()]= new ValueCell(commandParts[2]);
			return getGridText();
		}
		else if(commandParts[0].toLowerCase().equals("clear")){
			loc =new SpreadsheetLocation(commandParts[1]);
			sprSheet[loc.getRow()][loc.getCol()]=new EmptyCell();
			return getGridText();
		}
		return "";
	}
	@Override
	public int getRows(){
		return 20;
	}

	@Override
	public int getCols(){
		return 12;
	}

	@Override
	public Cell getCell(Location loc){
		return sprSheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
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

