package gameObjects;

import search.Position;

public class Pokemon {
	private Position position;
	private String name;
	
	//Constructor
	public Pokemon(Position position, String name) {
		super();
		this.position = position;
		this.name = name;
	}

	//Setters and Getters
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
