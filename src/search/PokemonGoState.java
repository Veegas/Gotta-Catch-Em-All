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
	private int stepsMoved;
	private ArrayList<Pokemon> pokemonsLeft;
	private Orientation orientation;
	
        public PokemonGoState() {
    	super();
    	this.currentPosition = new Position(0, 0);
    	this.orientation = Orientation.UP;
    	this.stepsMoved = 0;
    	this.pokemonsLeft = new ArrayList<Pokemon>();
        }
	
	//Constructor
	public PokemonGoState(Position currentPosition, int stepsMoved, ArrayList<Pokemon> pokemonsLeft,
			Orientation orientation) {
		super();
		this.currentPosition = currentPosition;
		this.stepsMoved = stepsMoved;
		this.pokemonsLeft = pokemonsLeft;
		this.orientation = orientation;
	}
	
	@SuppressWarnings("unchecked")
	public PokemonGoState(PokemonGoState oldState) {
	    super();
	    this.currentPosition = new Position(oldState.currentPosition);
	    this.orientation = oldState.orientation;
	    this.stepsMoved = oldState.stepsMoved;
	    this.pokemonsLeft = (ArrayList<Pokemon>) oldState.pokemonsLeft.clone();
	    int x = 1;
	}

	//Setters and Getters
	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getStepsMoved() {
		return stepsMoved;
	}

	public void setStepsMoved(int stepsMoved) {
		this.stepsMoved = stepsMoved;
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
//	    TODO: Check for logic in maze;
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
			if (pickUpPokemon(nextCell) == true) {
			    newState.pokemonsLeft = this.pokemonsLeft;
			}
	    }
	    newState.stepsMoved++;
	    	    
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
		return env.maze.getMaze()[this.currentPosition.getX()] [this.currentPosition.getY() - 1];
	    } catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getDownwardCell(PokemonGoEnvironment env) {
	    try {
		 return env.maze.getMaze()[this.currentPosition.getX()] [this.currentPosition.getY() + 1];	
	    }
	
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getLeftCell(PokemonGoEnvironment env) {
	   try {
	       return env.maze.getMaze()[this.currentPosition.getX() - 1] [this.currentPosition.getY()];  
	   }
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }
	}
	public Cell getRightCell(PokemonGoEnvironment env) {
	    try {
		return env.maze.getMaze()[this.currentPosition.getX() + 1] [this.currentPosition.getY()];
	    }
	    catch (Exception e) {
		//System.out.println("Current Position => " + this.currentPosition);
		throw e;
	    }	
	}
	
	public boolean pickUpPokemon(Cell cell) {
	    Pokemon cellPokemon = cell.getPokemon();
	    if (cellPokemon != null) {
		cell.removePokemon();
		pokemonsLeft.remove(cellPokemon);
		return true;
	    }
	    return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		final PokemonGoState other = (PokemonGoState) obj;
	    
	    if (!this.currentPosition.equals(other.currentPosition)) {
		return false;
	    }
	    
//	    if (this.stepsMoved != other.stepsMoved) {
//		return false;
//	    }
//	    
//	    if (this.pokemonsLeft != other.pokemonsLeft) {
//		return false;
//	    }
	    
	    if (!this.orientation.equals(other.orientation)) {
		return false;
	    }
		
	    return true;
	}
	
	public String toString() {
	    return this.getCurrentPosition() + "=> "  + this.getOrientation();
	}
}
