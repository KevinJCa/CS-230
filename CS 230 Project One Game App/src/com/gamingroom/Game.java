package com.gamingroom;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	/*
	 * An array list of active teams
	 */
	private List<Team> teams = new ArrayList<Team>();


	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	/**
	 * Constructs a new team instance
	 * 
	 * @param provide the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam(String name) {

		// a local team instance
		Team team = null;
		
		// Declares iterator for the 'teams' array list
		Iterator<Team> teamIterator = teams.iterator();
		
		// Iterates through the list and checks for teams with the same name, returning the existing instance if found
		while (teamIterator.hasNext()) {
			Team nextTeam = teamIterator.next();
			if (nextTeam.getName() == name) {
				team = nextTeam;
			}
		}
		
		// Reference to the singleton instance
		GameService service = GameService.getInstance();

		// if not found, make a new team instance and adds to list of teams
		if (team == null) {
			team = new Team(service.getNextTeamId(), name);
			teams.add(team);
			System.out.println("A new team has been added.");
		}

		// return the new/existing team instance to the caller
		return team;
	}
	
	@Override
	public String toString() {
		return "Game [id= " + super.getId() + ", name= " + super.getName() + "]";
	}

}
