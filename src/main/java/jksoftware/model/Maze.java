package jksoftware.model;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.joining;
import jksoftware.exception.MultipleEndPointsException;
import jksoftware.exception.MultipleStartPointsException;
import jksoftware.exception.NoEndCellException;
import jksoftware.exception.NoStartCellException;
import jksoftware.service.CellFactory;
import lombok.Getter;

public class Maze {

	@Getter
	private List<String> inputMazeMap;
	private List<List<Cell>> mazeMap;

	@Getter
	private StartCell startCell;
	@Getter
	private EndCell endCell;


	public Maze(final List<String> inputMazeMap) {
		this.inputMazeMap = inputMazeMap;
		initMaze(inputMazeMap);
	}

	private void initMaze(List<String> inputMazeMap) {
		this.mazeMap = new ArrayList<>();
		for (int i = 0; i < inputMazeMap.size(); i++) {
			final List<Cell> mazeRow = new ArrayList<>();
			for (int j = 0; j < inputMazeMap.get(i).length(); j++) {
				final Cell cell = CellFactory.createCell(inputMazeMap.get(i).charAt(j), i, j);
				checkAndInitStartCell(cell);
				checkAndInitEndCell(cell);
				mazeRow.add(cell);
			}
			this.mazeMap.add(mazeRow);
		}

		checkForStartAndEndFields();
	}

	public Cell getAbove(final Cell cell) {
		if (cell.getY().equals(0)) {
			return null;
		}

		return mazeMap.get(cell.getX()).get(cell.getY() - 1);
	}

	public Cell getBelow(final Cell cell) {
		if (cell.getY().equals(mazeMap.get(cell.getX()).size() - 1)) {
			return null;
		}

		return mazeMap.get(cell.getX()).get(cell.getY() + 1);
	}

	public Cell getLeft(final Cell cell) {
		if (cell.getX().equals(0)) {
			return null;
		}

		return mazeMap.get(cell.getX() - 1).get(cell.getY());
	}

	public Cell getRight(final Cell cell) {
		if (cell.getX().equals(mazeMap.size() - 1)) {
			return null;
		}

		return mazeMap.get(cell.getX() + 1).get(cell.getY());
	}

	private void checkAndInitStartCell(final Cell cell) {
		if (cell instanceof StartCell) {
			if (isNull(this.startCell)) {
				this.startCell = (StartCell) cell;
			} else {
				throw new MultipleStartPointsException(cell, this.startCell);
			}
		}
	}

	private void checkAndInitEndCell(final Cell cell) {
		if (cell instanceof EndCell) {
			if (isNull(this.endCell)) {
				this.endCell = (EndCell) cell;
			} else {
				throw new MultipleEndPointsException(cell, this.endCell);
			}
		}
	}

	private void checkForStartAndEndFields() {
		if (isNull(this.startCell)) {
			throw new NoStartCellException();
		}
		if (isNull(this.endCell)) {
			throw new NoEndCellException();
		}
	}

	@Override
	public String toString() {
		return mazeMap.stream()
				.map(row -> row.stream()
						.map(c -> String.valueOf(c.getCharacter()))
						.collect(joining("")))
				.collect(joining(System.getProperty("line.separator")));
	}
}
