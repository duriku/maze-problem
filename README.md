# Maze Solving
This is my solution for the  Maze Solving problem

### Building the app

`mvn clean install`

The maven command builds the app, executes the unit tests and packages the source files with the 
dependencies into a single executable jar `mazeproblem-1.0-SNAPSHOT.jar` under the target folder

### Starting the project
The built executable jar file can be started with the following command from the projects root directory
A filename of the maze has to be passed as a commandline parameter

`java -jar target/mazeproblem-1.0-SNAPSHOT.jar ./src/test/resources/valid-rectangle-maze.txt`

### Using the app
Once the app is launched it starts finding the shortest path using Breadth-first search technique. 
It prints out the maze with the shortest path to the console once the search is finished.
