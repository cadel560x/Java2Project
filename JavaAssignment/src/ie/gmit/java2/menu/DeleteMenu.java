package ie.gmit.java2.menu;

import ie.gmit.java2.Menu;

public class DeleteMenu extends Menu {
	
//	 Constructors
	public DeleteMenu() {
		setTitle("Delete Menu");

		setMenuItemLabel("Delete word");
		setMenuItemLabel("Delete word by word index");
	}

//	 Other methods
	public void deleteWord() {
		
		System.out.print("Please enter word to delete (Press 'Enter' to go back): ");
		optionSelected = console.nextLine();
		
		if (! optionSelected.equals("") ) {
			System.out.println("Word '" + optionSelected + "' deleted");
			parser.delete(optionSelected);
		}
		else {
//			If we reach here is beacause the key 'Enter' was pressed, so we want to go back in the menu, but we have to change the value of
//			'optionSelected' to something different than "" otherwise it will propagate the exit in outer do-while loops.			
			optionSelected = "-1";
		}
		
	}
	
	public void deleteWordByIndex() {
		int deleteIndex;
		
		try {
			System.out.print("Please enter number of word to delete (Press 'Enter' to go back): ");
			optionSelected = console.nextLine();
			deleteIndex = Integer.parseInt(optionSelected);
			
			System.out.println("Word number " + deleteIndex + " ( " + parser.get(deleteIndex) + " ) deleted.");
			parser.delete(deleteIndex);
		} catch (NumberFormatException e) {
			if (! optionSelected.equals(""))
				System.out.println("Invalid index. Please try again.");
			else
//				If we reach here is beacause the key 'Enter' was pressed, so we want to go back in the menu, but we have to change the value of
//				'optionSelected' to something different than "" otherwise it will propagate the exit in outer do-while loops.
				optionSelected = "-1";
			
		}
		
	}

	@Override
	public void execute() {
		switch(optionSelected) {
		case "1":
			deleteWord();
			break;
		case "2":
			deleteWordByIndex();
			break;
		}
	}

}
