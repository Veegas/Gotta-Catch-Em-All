package search;

import java.util.ArrayList;

import abstracts.State;

import gameObjects.Pokemon;

//represents our agent's state in the Gotta Catch'em all instance
public class PokemonGoState extends State {
	public PokemonGoState() {
	super();
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
	
}
