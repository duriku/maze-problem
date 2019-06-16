package jksoftware.service;

import jksoftware.model.Maze;

public class MazeService {

	public Maze solveMazePuzzle(final Maze maze){
		// Do not want to mutate the input maze
		final Maze result = cloneMaze(maze);

		return result;
	}


	private Maze cloneMaze(final Maze maze){
		return new Maze(maze.getInputMazeMap());
	}
}
