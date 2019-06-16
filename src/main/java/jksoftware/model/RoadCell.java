package jksoftware.model;

import static jksoftware.config.MazeConfig.EMPTY;
import static jksoftware.config.MazeConfig.PATH;

public class RoadCell extends Cell {

	public RoadCell(final int x, final int y) {
		super(x, y);
	}

	public RoadCell(final int x, final int y, final boolean path) {
		super(x, y);
		this.setPath(path);
	}

	@Override
	public char getCharacter() {
		return isPath() ? PATH :  EMPTY;
	}

}
