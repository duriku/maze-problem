package jksoftware.service;

import static jksoftware.config.MazeConfig.*;
import jksoftware.exception.InvalidCellException;
import jksoftware.model.*;

public class CellFactory {

	public static Cell createCell(char c, int x, int y) {
		switch (c) {
			case WALL:
				return new Wall(x, y);
			case EMPTY:
				return new RoadCell(x, y);
			case START:
				return new StartCell(x, y);
			case END:
				return new EndCell(x, y);
			case PATH:
				return new RoadCell(x, y, true);
			default:
				throw new InvalidCellException(c, x, y);
		}
	}
}
