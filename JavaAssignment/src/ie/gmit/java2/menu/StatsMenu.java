package ie.gmit.java2.menu;

import ie.gmit.java2.Menu;

public class StatsMenu extends Menu {
	
//	Constructors
	public StatsMenu() {
		setTitle("Statistics Menu");
		
		setMenuItemLabel("Word count");
		setMenuItemLabel("Average word size");
		setMenuItemLabel("Most common word");
	}
	
//	 Other methods
	public void wordCount() {
		System.out.println("The text has " + parser.count() + " words");
		
	}
	
	public void showAverageWordSize() {
		System.out.println("The average word size is: " + String.format( "%.2f", parser.averageWordSize() ) + " letters");
	}
	
	public void showMostCommonWord() {
		System.out.println("This may take a while depending on the size of the text source.....");
		System.out.println( "The most common word is: '" + parser.mostCommonWord() + "'" );
	}
	
	@Override
	public void execute() {
		switch(optionSelected) {
		case "1":
			wordCount();
			break;
		case "2":
			showAverageWordSize();
			break;
		case "3":
			showMostCommonWord();
			break;
		}


	}

}
