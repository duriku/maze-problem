package jksoftware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static java.util.stream.Collectors.toList;
import jksoftware.model.Maze;
import jksoftware.service.MazeService;

public class App {

	public static void main(String[] args) {
		final MazeService mazeService = new MazeService();
		try {
			validateInput(args);
			final Maze maze = new Maze(getFileFromInput(args[0]));
			final Maze solvedMaze = mazeService.solveMazePuzzle(maze);
			printMaze(solvedMaze);
		} catch (Exception ex) {
			System.err.println(ex.toString());
		}

	}

	private static void validateInput(String[] args) {
		if (args.length < 1) {
			throw new RuntimeException("Provide an input file");
		}
	}

	private static void printMaze(final Maze maze) {
		System.out.println("Solution: ");
		System.out.println(maze.toString());
	}

	private static List<String> getFileFromInput(final String fileName) throws IOException {
		return Files.lines(Paths.get(fileName)).collect(toList());
	}
}
