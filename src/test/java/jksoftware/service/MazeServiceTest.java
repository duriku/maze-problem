package jksoftware.service;

import jksoftware.model.Maze;
import jksoftware.utils.FileUtils;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class MazeServiceTest {
	private MazeService mazeService = new MazeService();

	@Test
	public void solveSimpleSquareMaze() throws Exception {
		final Maze inputMaze = new Maze(FileUtils.INSTANCE.loadFile("valid-square-maze.txt"));
		final Maze maze = mazeService.solveMazePuzzle(inputMaze);

		final Maze expectedMaze = new Maze(FileUtils.INSTANCE.loadFile("valid-square-maze-solved.txt"));
		assertThat(expectedMaze.toString(), CoreMatchers.is(maze.toString()));
	}

}