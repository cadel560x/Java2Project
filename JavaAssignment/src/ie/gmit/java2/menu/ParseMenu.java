package ie.gmit.java2.menu;

import ie.gmit.java2.Menu;

public class ParseMenu extends Menu {
//	 Fields
	private StatsMenu statm;
	private SearchMenu sm;
	private DeleteMenu dm;
	
//	 Constructors
	public ParseMenu() {
		setTitle("Parse Menu");	
			
		statm = new StatsMenu();
		sm = new SearchMenu();
		dm = new DeleteMenu();
			
		setMenuItemLabel("Show text");
		setMenuItemLabel("Statistics options");
		setMenuItemLabel("Search word");
		setMenuItemLabel("Delete options");
	}

//	 Other methods
	public void show() {
		parser.show();
	}

	@Override
	public void execute() {
		switch(optionSelected) {
		case "1":
			show();
			break;
		case "2":
			statm.display();
			break;
		case "3":
			System.out.println();
			sm.searchWord();
			break;
		case "4":
			dm.display();
			break;
		}
	}

}
