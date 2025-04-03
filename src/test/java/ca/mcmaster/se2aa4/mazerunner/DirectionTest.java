package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    public void testToString() {
        assertEquals("RIGHT", Direction.Right().toString());
        assertEquals("DOWN", Direction.Down().toString());
        assertEquals("LEFT", Direction.Left().toString());
        assertEquals("UP", Direction.Up().toString());
    }

    @Test
    public void testRights() {
        Direction dir = Direction.Up();

        assertTrue(Direction.Right().equals(dir.turnRight()));
        assertTrue(Direction.Down().equals(dir.turnRight().turnRight()));
        assertTrue(Direction.Left().equals(dir.turnRight().turnRight().turnRight()));
        assertTrue(Direction.Up().equals(dir.turnRight().turnRight().turnRight().turnRight()));
    }

    @Test
    public void testLefts() {
        Direction dir = Direction.Up();

        assertTrue(Direction.Left() .equals(dir.turnLeft()));
        assertTrue(Direction.Down() .equals(dir.turnLeft().turnLeft()));
        assertTrue(Direction.Right().equals(dir.turnLeft().turnLeft().turnLeft()));
        assertTrue(Direction.Up()   .equals(dir.turnLeft().turnLeft().turnLeft().turnLeft()));
    }
}
