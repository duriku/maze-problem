package jksoftware.model;

import static jksoftware.config.MazeConfig.END;

public class EndCell extends Cell {
	public EndCell(final int x, final int y) {
		super(x, y);
	}

	@Override
	public char getCharacter() {
		return END;
	}
}
