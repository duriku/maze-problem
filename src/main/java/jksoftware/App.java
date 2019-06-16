package jksoftware;

import java.io.File;
import jksoftware.model.Maze;
import jksoftware.service.MazeService;

public class App {

	public static void main(String[] args) {
		final File inputFile = getFileFromInput(args[0]);
		final Maze maze = parseMazeFromFile(inputFile);
		final MazeService mazeService = new MazeService();

		final Maze solvedMaze = mazeService.solveMazePuzzle(maze);
		printMaze(solvedMaze);
	}

	private static Maze parseMazeFromFile(final File inputFile) {
		return null;
	}

	private static void printMaze(Maze maze) {
	}

	private static File getFileFromInput(final String filePath) {
		return new File(filePath);
	}

	private static void findPath(final char[][] maze) {
	}

	private static void validateMaze(final char[][] maze) {

	}

}
