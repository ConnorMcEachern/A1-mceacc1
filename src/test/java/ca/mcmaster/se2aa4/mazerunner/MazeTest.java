package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class MazeTest {
    @Test
    public void testBuildSmallMaze() {
        try {
            Maze maze = new MazeFromFile().file(new File("./examples/small.maz.txt")).build();
            assertEquals(11, maze.getHeight());
            assertEquals(11, maze.getLength());

            assertTrue(maze.startingPosition().equals(new Position(8, 0)));
            assertTrue(maze.isWallAt(new Position(0, 0)));
            assertTrue(maze.isWallAt(new Position(7, 0)));
            assertFalse(maze.isWallAt(new Position(8, 0)));
            assertTrue(maze.isWallAt(new Position(9, 0)));
            
            assertTrue(maze.isWallAt (new Position(0, 7)));
            assertFalse(maze.isWallAt(new Position(1, 7)));
            assertFalse(maze.isWallAt(new Position(2, 7)));
            assertFalse(maze.isWallAt(new Position(3, 7)));
            assertTrue(maze.isWallAt (new Position(4, 7)));
            assertFalse(maze.isWallAt(new Position(5, 7)));
            assertTrue(maze.isWallAt (new Position(6, 7)));
            assertFalse(maze.isWallAt(new Position(7, 7)));
            assertTrue(maze.isWallAt (new Position(8, 7)));
            assertFalse(maze.isWallAt(new Position(9, 7)));
            assertTrue(maze.isWallAt (new Position(10, 7)));

        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testBuildMazesCheckSizes() {
        try {
            Maze maze = new MazeFromFile().file(new File("./examples/giant.maz.txt")).build();
            assertEquals(151, maze.getHeight());
            assertEquals(151, maze.getLength());

            maze = new MazeFromFile().file(new File("./examples/tiny.maz.txt")).build();
            assertEquals(7, maze.getHeight());
            assertEquals(7, maze.getLength());

            maze = new MazeFromFile().file(new File("./examples/rectangle.maz.txt")).build();
            assertEquals(21, maze.getHeight());
            assertEquals(51, maze.getLength());
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testBuildMazesTestRandomPositions() {
        try {
            Maze maze = new MazeFromFile().file(new File("./examples/direct.maz.txt")).build();
            assertTrue(maze.isWallAt(new Position(2, 3)));
            assertFalse(maze.isWallAt(new Position(3, 3)));
            assertTrue(maze.isWallAt(new Position(4, 3)));

            maze = new MazeFromFile().file(new File("./examples/huge.maz.txt")).build();
            assertTrue(maze.isWallAt(new Position(19, 50)));
            assertTrue(maze.isWallAt(new Position(20, 50)));
            assertFalse(maze.isWallAt(new Position(21, 50)));
            assertFalse(maze.isWallAt(new Position(20, 49)));
            assertFalse(maze.isWallAt(new Position(20, 51)));

            maze = new MazeFromFile().file(new File("./examples/rectangle.maz.txt")).build();
            assertTrue(maze.isWallAt(new Position(20, 50)));
            assertTrue(maze.isWallAt(new Position(19, 50)));
            assertTrue(maze.isWallAt(new Position(20, 49)));
            assertFalse(maze.isWallAt(new Position(19, 49)));
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
