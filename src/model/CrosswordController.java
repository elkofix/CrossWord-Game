package model;

import java.util.Collections;

/**
 * @author avillota
 * @since may 2022
 */
public class CrosswordController {
	
	/**
	 * Matrix of cells representing the crossword puzzle
	 */
	private Cell [][] crossword;
	
	public CrosswordController() {

	}
	/**
	 * method for initializing a crossword puzzle
	 * @param puzzle is a matrix of Strings containing 
	 * the initial state of a crossword puzzle
	 */
	public void initCrossword(String[][] puzzle) {
		int count = 1;
		this.crossword = new Cell[puzzle.length][puzzle[0].length];
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++) {
				if(puzzle[i][j].equals(" ")){
					crossword[i][j] = new Cell(CellType.BLACK, puzzle[i][j], 0);
				}else{
					crossword[i][j] = new Cell(CellType.OPEN, puzzle[i][j], count);
					count++;
				}
				
			}
		}


		
	}
	/**
	 * Method to verify if a crossword puzzle is initialized
	 * @return boolean, true if it is initialized, else false
	 */
	public boolean isInitialized(){
		return crossword!=null;
	}
	
	/**
	 * Method to provide the dimensions of the crossword puzzle
	 * @return
	 */
	public int[] getGameDimensions() {
		int[] dims = new int[2];
		dims[0]= crossword.length;
		dims[1]= crossword[0].length;
		
		return dims;
	}
	
	public Cell[][] getCells(){
		return crossword;
	}
	/**
	 * 
	 * @param letter
	 * @return
	 */
	public String getHint(String letter) {
		String msj = "\n Lo siento, no hay palabras con "+letter+"\n";
		Boolean isFound = false;
		if(isInitialized()){ 
			for (int i = 0; i < crossword.length && !isFound; i++) {
				for (int j = 0; j < crossword[0].length && !isFound; j++) {
					if(crossword[i][j].getLetter().equals(letter)){
						isFound = true;
						msj = " \nHay una palabra con "+letter+" en el crucigrama en la casilla "+crossword[i][j].getNumber()+"\n";
					}
				}
			}
		}else{
			msj = "\nSorry dude, the game is not initialized\n";
		}
		return msj;
	}
	
	/**
	 * 
	 * @param letter
	 * @param num
	 * @return
	 */
	public String evaluateCell(String letter, int num) {
		
		return null;
	}
	
	public String showCrossword() {
		int rows= crossword.length;
		int columns= crossword[0].length;
	
		String out="";
		String separator = "+---+ ";
		String line = "" + String.join("", Collections.nCopies(columns, separator));
		
		
		String numbers ="";
		String letters = "";
		int count =0;
		for(int i=0 ;i<rows ; i++) {
			numbers ="";
			letters ="";
			for(int j=0 ;j<columns ; j++) {
				count++;
				Cell actual = crossword[i][j];
				
				// numeros de dos cifras
				if (count>10) {
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
						
					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}else //una cifra
				{
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
						
					}else {
						numbers += " "+actual.getNumber() +"    ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}
			}
			//por cada fila se imprimen las lineas
			out+= line + "\n";
			out+= numbers + "\n";
			out+= letters + "\n";
			
			
		}
		out+= line + "\n";
		return out;
	}


}
