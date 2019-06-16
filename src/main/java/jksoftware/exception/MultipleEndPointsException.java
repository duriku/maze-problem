package jksoftware.exception;

import jksoftware.model.Cell;
import jksoftware.model.EndCell;

public class MultipleEndPointsException extends RuntimeException {
	private Cell cell;
	private EndCell endCell;

	public MultipleEndPointsException(final Cell cell, final EndCell endCell) {
		this.cell = cell;
		this.endCell = endCell;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MultipleEndPointsException{");
		sb.append("cell=").append(cell);
		sb.append(", endCell=").append(endCell);
		sb.append('}');
		return sb.toString();
	}
}
