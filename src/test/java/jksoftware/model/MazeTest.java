package jksoftware.model;

import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import jksoftware.exception.MultipleEndPointsException;
import jksoftware.exception.MultipleStartPointsException;
import jksoftware.exception.NoEndCellException;
import jksoftware.exception.NoStartCellException;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class MazeTest {

	@Test
	public void testSingleValidStartPoint() throws Exception {
		final Maze maze = new Maze(loadFile("valid-square-maze.txt"));
		assertThat(maze.getStartCell(), is(new StartCell(5, 1)));
	}

	@Test
	public void testSingleValidEndPoint() throws Exception {
		final Maze maze = new Maze(loadFile("valid-square-maze.txt"));
		assertThat(maze.getEndCell(), is(new StartCell(3, 3)));
	}

	@Test(expected= MultipleStartPointsException.class)
	public void testMultipleStartPoints() throws Exception {
		new Maze(loadFile("invalid-square-maze-duplicate-start.txt"));
		fail("MultipleStartPointsException was not raised");
	}

	@Test(expected= MultipleEndPointsException.class)
	public void testMultipleEndPoints() throws Exception {
		new Maze(loadFile("invalid-square-maze-duplicate-end.txt"));
		fail("MultipleEndPointsException was not raised");
	}

	@Test(expected= NoStartCellException.class)
	public void testMissingStartPoint() throws Exception {
		new Maze(loadFile("invalid-square-maze-missing-start.txt"));
		fail("NoStartCellException was not raised");
	}


	@Test(expected= NoEndCellException.class)
	public void testMissingEndPoint() throws Exception {
		new Maze(loadFile("invalid-square-maze-missing-end.txt"));
		fail("NoEndCellException was not raised");
	}

	private List<String> loadFile(final String path) throws Exception {
		return Files.readLines(new File(getClass().getResource("/".concat(path)).toURI()), Charset.forName("utf-8"));
	}

}