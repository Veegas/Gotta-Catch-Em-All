package search;

import java.util.ArrayList;

import abstracts.State;

import gameObjects.Pokemon;

public class AgentState extends State {
	private Position currentPosition;
	private int stepsMoved;
	private ArrayList<Pokemon> pokemonsLeft;
	private Orientation orientation;
	
}
