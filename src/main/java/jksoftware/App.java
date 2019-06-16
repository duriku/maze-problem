package jksoftware;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        final File inputFile = getFileFromInput(args[0]);
        final char[][] maze = parseMazeFromFile(inputFile);

        validateMaze(maze);
        findPath(maze);
        printMaze(maze);
    }

    private static File getFileFromInput(final String filePath) {
        return new File(filePath);
    }

    private static void findPath(final char[][] maze) {
    }

    private static void validateMaze(final char[][] maze) {

    }

    static char[][] parseMazeFromFile(final File file) {
        String fileName = "c://lines.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

        char[][] maze = new char[2][2];
        maze[0][0] = '#';
        maze[1][0] = '.';
        maze[0][1] = '.';
        maze[1][1] = '#';

        return maze;
    }

    static void printMaze(final char[][] maze) {
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                System.out.print(maze[y][x]);
            }
            System.out.println();
        }
    }
}
