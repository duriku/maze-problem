package jksoftware.service;

import java.util.LinkedList;
import static java.util.Objects.nonNull;
import jksoftware.model.*;

public class MazeService {

	public Maze solveMazePuzzle(final Maze input) {
		final Maze maze = cloneMaze(input); // Do not want to mutate the input maze

		final LinkedList<Cell> nextCellsToVisit = new LinkedList<>();
		nextCellsToVisit.add(maze.getStartCell());
		while (!nextCellsToVisit.isEmpty()) {
			final Cell currentCell = nextCellsToVisit.remove();

			if (currentCell instanceof EndCell) {
				markPathFromTheExit(currentCell);
				return maze;
			}

			addNeighborToQueue(nextCellsToVisit, currentCell, maze.getLeft(currentCell));
			addNeighborToQueue(nextCellsToVisit, currentCell, maze.getRight(currentCell));
			addNeighborToQueue(nextCellsToVisit, currentCell, maze.getAbove(currentCell));
			addNeighborToQueue(nextCellsToVisit, currentCell, maze.getBelow(currentCell));
		}
		return maze;
	}

	private void markPathFromTheExit(final Cell exit) {
		Cell pathItem = exit.getParent();
		while (!(pathItem instanceof StartCell)) {
			pathItem.setPath(true);
			pathItem = pathItem.getParent();
		}

	}

	private void addNeighborToQueue(final LinkedList<Cell> nextCellsToVisit, final Cell currentCell, final Cell nextCell) {
		if (nonNull(nextCell) && !(nextCell instanceof Wall) && !nextCell.isVisited()) {
			// TODO: REMOVE IT
			System.out.println(nextCell.toString() + " has parent " + currentCell.toString());
			nextCell.setParent(currentCell);
			nextCell.setVisited(true);
			nextCellsToVisit.add(nextCell);
		}
	}

	private Maze cloneMaze(final Maze maze) {
		return new Maze(maze.getInputMazeMap());
	}
}
