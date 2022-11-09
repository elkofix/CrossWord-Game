/**
 * 
 */
package model;

public class Cell {
	
	private CellType state;
	private String letter;
	private int number;
	
	
	public Cell(CellType state, String letter, int number) {
		this.state = state;
		this.letter = letter;
		this.number = number;
	}
	public CellType getState() {
		return state;
	}
	public void setState(CellType state) {
		this.state = state;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
