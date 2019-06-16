package jksoftware.model;

import jksoftware.exception.MultipleEndPointsException;
import jksoftware.exception.MultipleStartPointsException;
import jksoftware.exception.NoEndCellException;
import jksoftware.exception.NoStartCellException;
import jksoftware.utils.FileUtils;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class MazeTest {

	@Test
	public void testSingleValidStartPoint() throws Exception {
		final Maze maze = new Maze(FileUtils.INSTANCE.loadFile("valid-square-maze.txt"));
		assertThat(maze.getStartCell(), is(new StartCell(5, 1)));
		System.out.println(maze);
	}

	@Test
	public void testSingleValidEndPoint() throws Exception {
		final Maze maze = new Maze(FileUtils.INSTANCE.loadFile("valid-square-maze.txt"));
		assertThat(maze.getEndCell(), is(new StartCell(3, 3)));
	}

	@Test(expected = MultipleStartPointsException.class)
	public void testMultipleStartPoints() throws Exception {
		new Maze(FileUtils.INSTANCE.loadFile("invalid-square-maze-duplicate-start.txt"));
		fail("MultipleStartPointsException was not raised");
	}

	@Test(expected = MultipleEndPointsException.class)
	public void testMultipleEndPoints() throws Exception {
		new Maze(FileUtils.INSTANCE.loadFile("invalid-square-maze-duplicate-end.txt"));
		fail("MultipleEndPointsException was not raised");
	}

	@Test(expected = NoStartCellException.class)
	public void testMissingStartPoint() throws Exception {
		new Maze(FileUtils.INSTANCE.loadFile("invalid-square-maze-missing-start.txt"));
		fail("NoStartCellException was not raised");
	}


	@Test(expected = NoEndCellException.class)
	public void testMissingEndPoint() throws Exception {
		new Maze(FileUtils.INSTANCE.loadFile("invalid-square-maze-missing-end.txt"));
		fail("NoEndCellException was not raised");
	}

}