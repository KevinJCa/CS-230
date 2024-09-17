package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;

	// Declares an instance of GameService to null by default
	private static GameService service = null;
	
	// Default GameService Constructor
	private GameService() {}
	
	public static GameService getInstance() {
		
		if(service == null) {
			service = new GameService();
		}

		return service;
	}
	// The code above turns this into a singleton class by ensuring that there is only one
	// instance of the GameService class which can also be externally accessible. 

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		// Declares iterator for the 'games' array list
		Iterator<Game> gameIterator = games.iterator();
		
		// Iterates through the list and checks for games with the same name, returning the existing instance if found
		while (gameIterator.hasNext()) {
			Game nextGame = gameIterator.next();
			if (nextGame.getName() == name) {
				game = nextGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		// Declares iterator for the 'games' array list
		Iterator<Game> gameIterator = games.iterator();
		
		// Iterates through the list to check if the existing game has the same id input, then assigns that instance to the function's local variable.
		while (gameIterator.hasNext()) {
			Game nextGame = gameIterator.next();
			if(gameIterator.next().getId() == id) {
				game = nextGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
		// Declares iterator for the 'games' array list
		Iterator<Game> gameIterator = games.iterator();
		
		// Iterates through the list to check if the existing game has the same name, then assigns that instance to the function's local variable.
		while (gameIterator.hasNext()) {
			Game nextGame = gameIterator.next();
			if(nextGame.getName() == name) {
				game = nextGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	// Returns the next player identifier
	public long getNextPlayerId() {
		return nextPlayerId; 
	}
	
	// Returns the next team identifier
	public long getNextTeamId() {
		return nextTeamId;
	}
}
