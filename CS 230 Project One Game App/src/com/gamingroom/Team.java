package com.gamingroom;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	
	/*
	 * An array list of active players
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	/**
	 * Constructs a new player instance
	 * 
	 * @param provide the unique name of the player
	 * @return the player instance (new or existing)
	 */
	public Player addPlayer(String name) {

		// a local player instance
		Player player = null;
		
		// Declares iterator for the 'players' array list
		Iterator<Player> playerIterator = players.iterator();
		
		// Iterates through the list and checks for players with the same name, returning the existing instance if found
		while (playerIterator.hasNext()) {
			Player nextPlayer = playerIterator.next();
			if (nextPlayer.getName() == name) {
				player = nextPlayer;
			}
		}
		
		// Reference to the singleton instance
		GameService service = GameService.getInstance();

		// if not found, make a new player instance and adds to list of players
		if (player == null) {
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
			System.out.println("A new player has been added");
		}

		// return the new/existing player instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id= " + super.getId() + ", name= " + super.getName() + "]";
	}
	
}
