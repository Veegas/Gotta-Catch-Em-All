package mazeGenerator;

//represents a cell in the maze, each cell is either a passage or a wall
public class Cell {
	private boolean hasPokemon = false;
	private boolean Visited = false;
	private boolean blocked = true;
	private boolean Start = false;
	private boolean End = false;
	private int x;
	private int y;
	private Cell parent;

	// Constructor
	public Cell(boolean hasPokemon, int x, int y, Cell parent) {
		this.hasPokemon = hasPokemon;
		this.x = x;
		this.y = y;
		this.parent = parent;
	}

	// Setters and Getters
	public boolean hasPokemon() {
		return hasPokemon;
	}

	public void addPokemon(boolean p) {
		this.hasPokemon = p;
	}

	public boolean isVisited() {
		return Visited;
	}

	public void setVisited(boolean visited) {
		Visited = visited;
	}

	public Integer getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

}
