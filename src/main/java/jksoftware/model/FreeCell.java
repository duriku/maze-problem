package jksoftware.model;

public class FreeCell extends Cell {

	private boolean visited;

	public FreeCell(final int x, final int y) {
		super(x, y);
		this.visited = false;
	}

	public boolean isVisited() {
		return visited;
	}

	public FreeCell setVisited(final boolean visited) {
		this.visited = visited;
		return this;
	}

}
