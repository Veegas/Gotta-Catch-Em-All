package search;

//Postion of the agent in the maze
public class Position {
	private int x;
	private int y;
	
	//Constructor
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Position(Position oldPosition) {
	    super();
	    this.x = oldPosition.x;
	    this.y = oldPosition.y;
	}

	//Setters and Getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
	    return "[x: " + this.x + ", y: " + this.y + "]";
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + x;
	    result = prime * result + y;
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
	    Position other = (Position) obj;
	    if (x != other.x)
		return false;
	    if (y != other.y)
		return false;
	    return true;
	}
	
	
	
	
	
}
