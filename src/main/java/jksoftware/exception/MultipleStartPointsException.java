package jksoftware.exception;

import jksoftware.model.Cell;
import jksoftware.model.StartCell;

public class MultipleStartPointsException extends RuntimeException {
	public MultipleStartPointsException(final Cell cell, final StartCell startCell) {
	}
}
