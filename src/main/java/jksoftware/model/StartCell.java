package jksoftware.model;

import static jksoftware.config.MazeConfig.START;

public class StartCell extends Cell {

	public StartCell(final int x, final int y) {
		super(x, y);
		this.setVisited(true);
	}

	@Override
	public char getCharacter() {
		return START;
	}
}
