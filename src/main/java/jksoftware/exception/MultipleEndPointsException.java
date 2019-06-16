package jksoftware.exception;

import jksoftware.model.Cell;
import jksoftware.model.EndCell;

public class MultipleEndPointsException extends RuntimeException {
	public MultipleEndPointsException(final Cell cell, final EndCell endCell) {
	}
}
