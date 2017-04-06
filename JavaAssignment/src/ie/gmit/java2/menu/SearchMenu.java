package ie.gmit.java2.menu;

import ie.gmit.java2.Menu;

public class SearchMenu extends Menu {

//	 Constructors
	public SearchMenu() {
		setTitle("Search Menu");
	}

//	 Other methods
	public void searchWord() {
		String msg;
		
		System.out.print("Please enter the word to search (Press 'Enter' to go back): ");
		optionSelected = console.nextLine();
		
		if (! optionSelected.equals("")) {
			msg = "The word '" + optionSelected + "' has ";
			if ( parser.contains(optionSelected) ) {
				System.out.println(msg += "been found.");
				printOcurrences(optionSelected);
			}
			else
				System.out.println(msg += "not been found");
		}
	}

	private void printOcurrences(String word) {
		String msg;
		
		msg = "Occurrences: " + parser.countOcurrences(word) + "\n";
		msg += "First ocurrence is at word number " + parser.getFirstIndex(word) + " of the text.\n";
		msg += "Last ocurrence is at word number " + parser.getLastIndex(word) + " of the text.\n";
		msg += "Found at word number(s):\n";
		
		System.out.print(msg);
		for ( int index : parser.getAllIndeces(word) )
			System.out.print(index + " ");
		
		System.out.println("\n");
			
	}

//	There is no need to implement this method for this menu. It is here for inhertance of abstract methods.
	@Override
	public void execute() {
		
	}

}
