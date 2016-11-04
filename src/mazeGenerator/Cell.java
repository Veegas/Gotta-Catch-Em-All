package mazeGenerator;
import java.util.ArrayList;

import gameObjects.*;
import search.Position;

//represents a cell in the maze, each cell is either a passage or a wall
public class Cell {
	private boolean hasPokemon = false;
	private Pokemon Pokemon;
	private boolean Visited = false;
	private boolean blocked = true;
	private boolean Start = false;
	private boolean End = false;
	private Position position;
	private Cell parent;

	// Constructor
	public Cell(boolean hasPokemon, int x, int y, Cell parent) {
		this.hasPokemon = hasPokemon;
		this.position = new Position(x, y);
		this.parent = parent;
	}

	// Setters and Getters
	public boolean hasPokemon() {
		return hasPokemon;
	}

	public void addPokemon(boolean p, ArrayList<Pokemon> Pokemons) {
		this.hasPokemon = p;
		if(p) {
		    this.Pokemon = new Pokemon("Pikachu",  Pokemons.size()+1, this);
		    Pokemons.add(this.Pokemon);
		}
	}
	
	public Pokemon getPokemon() {
	    return this.Pokemon;
	}
	
	public void removePokemon() {
	    this.hasPokemon = false;
	    this.Pokemon = null;
	}

	public boolean isVisited() {
		return Visited;
	}

	public void setVisited(boolean visited) {
		Visited = visited;
	}

	public Integer getX() {
		return this.position.getX();
	}

	public void setX(int x) {
		this.position.setX(x);
	}

	public Integer getY() {
	    return this.position.getY();
	}

	public void setY(int y) {
	    this.position.setY(y);
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Cell getParent() {
		return parent;
	}

	public void setParent(Cell parent) {
		this.parent = parent;
	}

	public boolean isStart() {
		return Start;
	}

	public void setStart(boolean start) {
		Start = start;
	}

	public boolean isEnd() {
		return End;
	}

	public void setEnd(boolean end) {
		End = end;
	}
	
	public Position getPosition() {
	    return this.position;
	}
	
	public void setPosition(Position position) {
	    this.position = position;
	}
	
	public String toString() {
	    return this.position +  " > " + this.cellStatus() ;
	}
	
	public String cellStatus() {
		String status = "";
	    	if (this.getY() == 0) {
			status +=("|");
		}
		if (this.isStart()) {
			status +=("S ");
		} 
		/*else if (this.equals(currentCell)) {
		    status +=("A ");
		}*/
		else {
			if (this.isEnd()) {
				status +=("E ");
			} else {
				if (this.isBlocked()) {
					status +=("* ");
				} else {
					if (this.hasPokemon()) {
						status +=("P ");
					} else {
						status +=("o ");
					}
				}
			}
		}
		return status;

	}

}
