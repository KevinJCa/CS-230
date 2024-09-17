package com.gamingroom;

public class Entity {
	
	private long id;
	private String name;
	
	@SuppressWarnings("unused")
	private Entity() {
	}
	
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		
		return "Entity [id= " + id + ", name= " + name + "]";
		
	}
	
}
