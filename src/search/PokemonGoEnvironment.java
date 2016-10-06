package search;

import abstracts.Environment;
import mazeGenerator.Maze;

public class PokemonGoEnvironment extends Environment {
    Maze maze;
    
    public PokemonGoEnvironment(Maze maze) {
	this.maze = maze;
    }
}
