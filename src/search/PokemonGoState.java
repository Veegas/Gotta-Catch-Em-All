package search;

import java.util.ArrayList;

import abstracts.Environment;
import abstracts.State;

import gameObjects.Pokemon;
import mazeGenerator.Cell;
import mazeGenerator.Maze;

//represents our agent's state in the Gotta Catch'em all instance
public class PokemonGoState extends State {
    private Position currentPosition;
	private int stepsLeft;
	private ArrayList<Pokemon> pokemonsLeft;
	private Orientation orientation;
	
        public PokemonGoState() {
    	super();
    	this.currentPosition = new Position(0, 0);
    	this.orientation = Orientation.UP;
    	this.stepsLeft = 0;
    	this.pokemonsLeft = new ArrayList<Pokemon>();
        }
	
	//Constructor
	public PokemonGoState(Position currentPosition, int stepsMoved, ArrayList<Pokemon> pokemonsLeft,
			Orientation orientation) {
		super();
		this.currentPosition = currentPosition;
		this.stepsLeft  = stepsMoved;
		this.pokemonsLeft = pokemonsLeft;
		this.orientation = orientation;
	}
	
	@SuppressWarnings("unchecked")
	public PokemonGoState(PokemonGoState oldState) {
	    super();
	    this.currentPosition = new Position(oldState.currentPosition);
	    this.orientation = oldState.orientation;
	    this.stepsLeft  = oldState.stepsLeft;
	    this.pokemonsLeft = (ArrayList<Pokemon>) oldState.pokemonsLeft.clone();
	}

	//Setters and Getters
	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}


	public ArrayList<Pokemon> getPokemonsLeft() {
		return pokemonsLeft;
	}

	public void setPokemonsLeft(ArrayList<Pokemon> pokemonsLeft) {
		this.pokemonsLeft.clear();
		this.pokemonsLeft.addAll(pokemonsLeft);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public PokemonGoState moveForward(Environment environment) {
	    PokemonGoEnvironment env = (PokemonGoEnvironment) environment;
	    Maze maze = env.maze;
	    PokemonGoState newState = new PokemonGoState(this);

	    Cell nextCell = null;
	    switch (this.orientation) {
	    	case UP:
	    	   if (canMoveUp(env) == true) {
	    	       nextCell = this.getUpwardCell(env);
	    	       newState.currentPosition.setY(newState.currentPosition.getY() - 1);
	    	   } else {
	    	       return null;
	    	   }
	    	    break;
	    	case DOWN:
	    	if (canMoveDown(env) == true) {
	    	    	nextCell = this.getDownwardCell(env);
	    	       newState.currentPosition.setY(newState.currentPosition.getY() + 1);
	    	   } else {
	    	       return null;
	    	   }
	    	    break;
	    	case LEFT:
	    	if (canMoveLeft(env) == true) {
	    	       nextCell = this.getLeftCell(env);
	    	       newState.currentPosition.setX(newState.currentPosition.getX() - 1);
	    	} else {
	    	       return null;
	    	   }
	    	    break;
	    	case RIGHT:
	    	if (canMoveRight(env) == true) {
	    	    	nextCell = this.getRightCell(env); 
	    	       newState.currentPosition.setX(newState.currentPosition.getX() + 1);  
	    	} else {
	    	       return null;
	    	   }
	    	    break;
	    	default: break;
		}
	    
	    if (nextCell != null) {
		newState.pickUpPokemon(nextCell, env.maze);
	    }
	    if (newState.stepsLeft > 0) {
		newState.stepsLeft --;
	    }

	    	    
	    return newState;
	}
	
	public boolean canMoveUp(PokemonGoEnvironment env) {
	    if (this.currentPosition.getY() == 0 )
		return false;
	    
	    Cell UpperCell = this.getUpwardCell(env);
	    if (UpperCell.isBlocked()) {
		return false;
	    }	 
	    return true;
	}
	
	public boolean canMoveDown(PokemonGoEnvironment env) {
	    if (this.currentPosition.getY() == env.maze.getHeight() - 1)
		return false;
	    
	    Cell DownCell = this.getDownwardCell(env);
	    if (DownCell.isBlocked()) {
		return false;
	    }	 
	    return true;
	}
	
	public boolean canMoveRight(PokemonGoEnvironment env) {
	    if (this.currentPosition.getX() == env.maze.getWidth() - 1)
		return false;
	    
	    Cell RightCell = this.getRightCell(env);
	    if (RightCell.isBlocked()) {
		return false;
	    }	 
	    return true;
	}
	
	public boolean canMoveLeft(PokemonGoEnvironment env) {
	    if (this.currentPosition.getX() == 0 )
		return false;
	    
	    Cell LeftCell = this.getLeftCell(env);
	    if (LeftCell.isBlocked()) {
		return false;
	    }	 
	    return true;
	}
	
	public PokemonGoState rotateLeft(Environment environment) {
	    PokemonGoEnvironment env = (PokemonGoEnvironment) environment;
	    Maze maze = env.maze;
	    PokemonGoState newState = new PokemonGoState(this);
//	    newState.pokemonsLeft = env.maze.getPokemonsGenerated();
	    switch (this.orientation) {
        	    case UP: newState.orientation = Orientation.LEFT; break;
        	    case DOWN: newState.orientation = Orientation.RIGHT; break;
        	    case LEFT: newState.orientation = Orientation.DOWN; break;
        	    case RIGHT: newState.orientation = Orientation.UP; break;
	    }
	    return newState;	
	 }
	
	public PokemonGoState rotateRight(Environment environment) {
	    PokemonGoEnvironment env = (PokemonGoEnvironment) environment;
	    Maze maze = env.maze;
	    PokemonGoState newState = new PokemonGoState(this);
//	    newState.pokemonsLeft = env.maze.getPokemonsGenerated();
	    switch (this.orientation) {
        	    case UP: newState.orientation = Orientation.RIGHT; break;
        	    case DOWN: newState.orientation = Orientation.LEFT; break;
        	    case LEFT: newState.orientation = Orientation.UP; break;
        	    case RIGHT: newState.orientation = Orientation.DOWN; break;
	    }
	    return newState;
	}
	
	public Cell getUpwardCell(PokemonGoEnvironment env) {
	    try {
		return env.maze.getMazeCell(this.currentPosition.getX(),this.currentPosition.getY() - 1);
	    } catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getDownwardCell(PokemonGoEnvironment env) {
	    try {
		 return env.maze.getMazeCell(this.currentPosition.getX(), this.currentPosition.getY() + 1);	
	    }
	
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getLeftCell(PokemonGoEnvironment env) {
	   try {
	       return env.maze.getMazeCell(this.currentPosition.getX() - 1,this.currentPosition.getY());  
	   }
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getRightCell(PokemonGoEnvironment env) {
	    try {
		return env.maze.getMazeCell(this.currentPosition.getX() + 1, this.currentPosition.getY());
	    }
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }	
	}
	
	public boolean pickUpPokemon(Cell cell, Maze maze) {
	    Pokemon cellPokemon = cell.getPokemon();
	    if (cellPokemon != null) {
		this.pokemonsLeft.remove(cellPokemon);
		return true;
	    }
	    return false;
	}
	

	
	

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((currentPosition == null) ? 0
		    : currentPosition.hashCode());
	    result = prime * result
		    + ((orientation == null) ? 0 : orientation.hashCode());
	    result = prime * result
		    + ((pokemonsLeft == null) ? 0 : pokemonsLeft.hashCode());
//	    result = prime * result + stepsMoved;
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
	    PokemonGoState other = (PokemonGoState) obj;
	    if (currentPosition == null) {
		if (other.currentPosition != null)
		    return false;
	    } else if (!currentPosition.equals(other.currentPosition))
		return false;
	    if (orientation != other.orientation)
		return false;
	    if (pokemonsLeft == null) {
		if (other.pokemonsLeft != null)
		    return false;
	    } else if (!pokemonsLeft.equals(other.pokemonsLeft))
		return false;
	    
	    if (stepsLeft >= 0) {
		if (stepsLeft != other.stepsLeft) {
		    return false;
		}
	    }
	    return true;
	}

	public String toString() {
	    return  this.getCurrentPosition() + " => "  + this.getOrientation() + " - Steps Left: " + stepsLeft + " -  Pokemons Left: "  + pokemonsLeft.size();
	}

	public int getStepsLeft() {
	    return stepsLeft;
	}

	public void setStepsLeft(int stepsLeft) {
	    this.stepsLeft = stepsLeft;
	}
}
