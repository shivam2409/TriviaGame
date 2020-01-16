package p1;

public class Main {

	public static void main(String[] args) {
		
		// Display menu
		Game_Engine.DisplayMenu();
		//Player p=new Player();
		int choice = Game_Engine.SelectMenuOptions();
	
		switch(choice) {
		case 1:
			Game_Engine.logInMenu();
			break;
		case 2:
			Game_Engine.createPlayer();
			break;
		case 3:
			System.out.println("Thank you for playing Trivia!");
			break;
		default:
			break;
		}
	}
}