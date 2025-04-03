package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PathTest {
    private Path path;
    private Position startPosition;

    @BeforeEach
    void setUp() {
        startPosition = new Position(0, 0); 
        path = new Path(startPosition);
    }

    @Test
    void testInitialPosition() {
        assertEquals(startPosition, path.getPosition());
    }

    @Test
    void testInitialDirection() {
        assertEquals(Direction.Right(), path.getDirection());
    }

    @Test
    void testTravel() {
        Position newPos = startPosition.move(Direction.Right());
        path.travel();
        assertTrue(newPos.equals(path.getPosition()));
        assertEquals("F", path.toString());
    }

    @Test
    void testTurnLeft() {
        Direction newDir = Direction.Right().turnLeft();
        path.turnLeft();
        assertEquals(newDir, path.getDirection());
        assertEquals("L", path.toString());
    }

    @Test
    void testTurnRight() {
        Direction newDir = Direction.Right().turnRight();
        path.turnRight();
        assertEquals(newDir, path.getDirection());
        assertEquals("R", path.toString());
    }

    @Test
    void testComplexPath() {
        path.travel();
        path.turnLeft();
        path.travel();
        path.turnRight();
        path.travel();
        assertEquals("FLFRF", path.toString());
    }
}