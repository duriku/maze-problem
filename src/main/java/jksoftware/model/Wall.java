package jksoftware.model;

import static jksoftware.config.MazeConfig.WALL;

public class Wall extends Cell{
	public Wall(final int x, final int y) {
		super(x, y);
	}

	@Override
	public char getCharacter() {
		return WALL;
	}
}
