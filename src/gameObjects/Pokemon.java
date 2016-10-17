package gameObjects;

import search.Position;

public class Pokemon {
	private String name;
	private int id;
	
	//Constructor
	public Pokemon(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	//Setters and Getters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}
	
	public String toString() {
	    return "id: " + this.id + ", name: " + this.name;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + id;
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Pokemon other = (Pokemon) obj;
	    if (id != other.id)
		return false;
	    return true;
	}
	
	
	
	
}
