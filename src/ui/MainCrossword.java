/**
 * @author avillota
 * @since may 2022
 */

package ui;

import java.util.Scanner;
import model.CrosswordController;


public class MainCrossword {
	private CrosswordController crossword;
	private Scanner sc;
	
	public MainCrossword(){
		sc= new Scanner(System.in);
		crossword = new CrosswordController();
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome to the Icesi's Crossword");
		MainCrossword ppal= new MainCrossword();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);

	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Show the crossword puzzle\n" +
				"(2) Init game \n"+
				"(3) Provide a hint\n"+
				"(4) Evaluate cell\n" +
				"(5) Evaluate word\n"+
				"(0) To leave the application"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			printCrossword();
			break;
		case 2:
			intGame();
			break;
	
		case 3:
			giveHint();
			break;

		case 4:
			evaluateLetter();
			break;
		case 5:
			evaluateWord();
			break;
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

public void evaluateWord() {
		
		
	}


public void evaluateLetter() {
	System.out.println("Please insert a letter to evaluate");
	String letter= sc.nextLine();
	
	System.out.println("Please insert a cell number");
	int num= sc.nextInt();
	sc.nextLine();
	String answer = crossword.evaluateCell(letter,  num);
	
	System.out.println(answer);
	
		
	}


public void giveHint() {
	System.out.println("\nTo provide a hint, please insert a letter\n");
	String letter= sc.nextLine();
	
	String answer = crossword.getHint(letter);
	
	System.out.println(answer);
	
		
	}


private void intGame() {
	System.out.println("\nThe game is about to get initialized please wait\n");
	TestCases test = new TestCases();
	crossword.initCrossword(test.getSmall());
	System.out.println("\nThe game has been initialized with the small test case\n");
}


/**
 * Method for printing the crossword puzzle 
 */
	public void printCrossword() {
		
		//Se pregunta si el juego está inicializado
		if(crossword.isInitialized()) {
			System.out.println(crossword.showCrossword());
			
			
		}else {
			System.out.println("\nSorry dude, the game is not initialized\n");
		}
		
	}




}
