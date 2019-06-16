package jksoftware.service;

import jksoftware.exception.ExitUnreachableException;
import jksoftware.model.Maze;
import jksoftware.utils.FileUtils;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;

public class MazeServiceTest {
	private MazeService mazeService = new MazeService();

	@Test
	public void solveSquareMaze() throws Exception {
		solveAndAssertMaze("valid-square-maze.txt", "valid-square-maze-solved.txt");
	}

	@Test
	public void solveRectangleMaze() throws Exception {
		solveAndAssertMaze("valid-rectangle-maze.txt", "valid-rectangle-maze-solved.txt");
	}

	@Test(expected = ExitUnreachableException.class)
	public void solveUnreachableRectangleMaze() throws Exception {
		final Maze inputMaze = new Maze(FileUtils.INSTANCE.loadFile("invalid-rectangle-maze-unreachable.txt"));
		mazeService.solveMazePuzzle(inputMaze);
		fail("ExitUnreachableException was not thrown ");
	}

	private void solveAndAssertMaze(final String inputMazeFileName, final String expectedMazeFileName) throws Exception {
		final Maze inputMaze = new Maze(FileUtils.INSTANCE.loadFile(inputMazeFileName));
		final Maze maze = mazeService.solveMazePuzzle(inputMaze);

		final Maze expectedMaze = new Maze(FileUtils.INSTANCE.loadFile(expectedMazeFileName));
		assertThat(expectedMaze.toString(), CoreMatchers.is(maze.toString()));

		System.out.println(maze.toString());
		System.out.println();
	}

}