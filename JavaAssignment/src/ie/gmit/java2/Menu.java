package ie.gmit.java2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.gmit.java2.menu.ParseMenu;
import ie.gmit.java2.parser.FileParser;
import ie.gmit.java2.parser.UrlParser;

public abstract class Menu {
/*  
    Static fields
	(Scanner) 'console' is set 'static' in order to be the very same (Scanner) throughout all methods in all 'Menu' child objects
	'parser', the parser to be used through the whole application
	'option', storage of user selection in static context
*/
	protected static Scanner console = new Scanner(System.in);
	protected static Parser parser;
	private static String option;

/*	
    Instance variables, each object have one of these fields
	(List<String>) 'menuItemLabels' is to store menu-item labels on each menu
	'title' is the menu title
	'optionSelected', storage of user selection
*/
	private List<String> menuItemLabels = new ArrayList<String>();
	private String title;
	protected String optionSelected;
	
	
//	 Constructors
	public Menu() {
	}
	
//	 Setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMenuItemLabel(String menuLabel) {
		menuItemLabels.add(menuLabel);
	}

	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	//	 Other methods
/*
	This method is for choosing between a file or URL. It doesn't really belong to any menu but we don't want it to be called from everywhere
	So those are the reasons why this method is static and private
*/
	private static void choose() {
		ParseMenu pm = new ParseMenu();
		
		do {
			System.out.print("\nPlease enter textfile or URL to parse. (Press 'Enter' to go exit): ");
			option = console.nextLine();
			
			if (! option.equals("") )
				try {
					parser = new FileParser(option);
					pm.display();
				} catch (Exception e1) {
					if ( !(option.startsWith("http://")) && !(option.startsWith("https://")) )
						option = "http://" + option;
					
					try {
						parser = new UrlParser(option);
						pm.display();
					} catch (IOException e2) {
						System.out.println("No file nor URL were found. Please try again.");
					}
				}
			
		} while ( ! option.equals(""));
		
	}
	
	public void exceptionHandler(Exception e) {
		System.err.println("\nPlease send an email to G00329649@gmit.ie with the following information: ");
		e.printStackTrace();
	}

	public void display() {
		int index;
		int i;
		
		do {
			i = 1;
			
			System.out.println();
			System.out.println(title);
			for ( int j = 0; j < title.length(); j++ )
				System.out.print("=");
			System.out.println();
			System.out.println("Please select an option:");
			
			for ( String menuItemLabel : menuItemLabels ) {
			    System.out.println(i + ". " + menuItemLabel);
			    i++;
			}
			System.out.print("Choice (Press 'Enter' to go back): ");
			optionSelected = console.nextLine();
					
			try {
//				Convert 'optionSelected' from (String) to (int) and store it in 'index' because is more legible to work with
				index = Integer.parseInt(optionSelected);
				
//				After all iterations done, 'i' holds the last index of the menu that is always the exit/go back option
//				Check if 'index' is out of menu range
				if ( index >= i  ||  index < 1 ) {
					System.out.println("Invalid option. Please try again.");
				}
//				We are in menu index range, execute/display what was selected
				else if ( index != i ) {
					this.execute();
				}
			} catch (NumberFormatException e) {
//				If we are here is because either an 'Enter' was inputed or something different than a number was inputed
				if (! optionSelected.equals(""))
					System.out.println("Invalid option. Please try again.");
			}
			
//		After all iterations done, 'i' holds the last index of the menu that is always the exit/go back option
		} while ( ! optionSelected.equals("") );
	}
	
//	This helper method executes the switch-case clause in every menu object
	public abstract void execute();

	
//	The reason to put the 'main()' method here is because it is more handy to manipulate static fields and static methods here, like (Scanner) 'console' and since 'main()' is static.... 
	public static void main(String[] args) {
		
		System.out.println("Welcome to Javier's File/URL parser\n");

		Menu.choose();
		
		console.close();
		
		System.out.println("\nBye-bye");

	}

}