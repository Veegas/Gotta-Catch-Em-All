package search;

import java.util.ArrayList;

import abstracts.Environment;
import abstracts.State;

import gameObjects.Pokemon;
import mazeGenerator.Cell;
import mazeGenerator.Maze;

//represents our agent's state in the Gotta Catch'em all instance
public class PokemonGoState extends State {
	public PokemonGoState() {
	super();
	this.currentPosition = new Position(0, 0);
	this.orientation = Orientation.UP;
	this.stepsMoved = 0;
	this.pokemonsLeft = new ArrayList<Pokemon>();
    }

	private Position currentPosition;
	private int stepsMoved;
	private ArrayList<Pokemon> pokemonsLeft;
	private Orientation orientation;
	
	
	//Constructor
	public PokemonGoState(Position currentPosition, int stepsMoved, ArrayList<Pokemon> pokemonsLeft,
			Orientation orientation) {
		super();
		this.currentPosition = currentPosition;
		this.stepsMoved = stepsMoved;
		this.pokemonsLeft = pokemonsLeft;
		this.orientation = orientation;
	}
	
	public PokemonGoState(PokemonGoState oldState) {
	    this.currentPosition = oldState.currentPosition;
	    this.orientation = oldState.orientation;
	    this.stepsMoved = oldState.stepsMoved;
	    this.pokemonsLeft = oldState.pokemonsLeft;
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
	
	public PokemonGoState movcelleForward(Environment environment) {
	    PokemonGoEnvironment ourEnvironment = (PokemonGoEnvironment) environment;
	    Maze ourMaze = ourEnvironment.maze;
//	    TODO: Check for logic in maze;
	    switch (this.orientation) {
	    	case UP: 
	    	    break;
	    	case DOWN: 
	    	    break;
	    	case LEFT: 
	    	    break;
	    	case RIGHT: 
	    	    break;
	    	default: break;
	    }
	    PokemonGoState newState = new PokemonGoState(this);
	    newState.stepsMoved++;
	    return newState;
	}
	
	public boolean canMoveUp(Maze maze) {
	    if (this.currentPosition.getY() == 0 )
		return false;
	    
	    Cell UpperCell = maze.getMaze()[this.currentPosition.getX()] [this.currentPosition.getY() - 1];
	    if (UpperCell.isBlocked()) {
		return false;
	    }
	    if (UpperCell.hasPokemon()) {
		
	    }
	   
	    
	}
	
	public boolean canMoveRight() {
	    
	}
	
	public boolean canMoveLeft() {
	    
	}
	
	public boolean canMoveDown() {
	    
	}
	
	public PokemonGoState rotateLeft() {
	    return this;
	}
	
	public PokemonGoState rotateRight() {
	    return this;
	}
	
}
