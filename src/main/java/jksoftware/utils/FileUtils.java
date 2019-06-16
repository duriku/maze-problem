package jksoftware.utils;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public class FileUtils {

	public static FileUtils INSTANCE = new FileUtils();

	private FileUtils() {
		// singleton
	}

	public List<String> loadFile(final String path) throws IOException, URISyntaxException {
		System.out.println(getClass().getResource("/".concat(path)));
		return Files.readLines(new File(getClass().getResource("/".concat(path)).toURI()), Charset.forName("utf-8"));
	}
}
