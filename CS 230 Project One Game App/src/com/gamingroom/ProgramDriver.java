package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// reference to the singleton instance
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		
		// Testing addTeam within the Game class
		System.out.println("\nTesting the addition of another team instance");
		Team team1 = game1.addTeam("team1");
		System.out.println(team1);
		
		// Testing addPlayer within the Team class
		System.out.println("\nTesting the addition of another player instance");
		Player player1 = team1.addPlayer("player1");
		System.out.println(player1);
		
		// Testing entity methods
		System.out.println("\nTesting getId from entity using a team instance");
		System.out.println("Team 1 id: "+team1.getId());
		
		System.out.println("\nTesting getName from entity using a team instance");
		System.out.println("Team 1 name: "+team1.getName());
		
		
	}
}
