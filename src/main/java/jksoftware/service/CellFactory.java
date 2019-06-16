package jksoftware.service;

import jksoftware.exception.InvalidCellException;
import jksoftware.model.*;

public class CellFactory {

	public static Cell createCell(char c, int x, int y) {
		switch (c) {
			case '#':
				return new Wall(x, y);
			case ' ':
				return new FreeCell(x, y);
			case 'S':
				return new StartCell(x, y);
			case 'E':
				return new EndCell(x, y);
			default:
				throw new InvalidCellException(c, x, y);
		}
	}
}
