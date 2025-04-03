package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void testToString() {
        Position pos = new Position(4, 3);
        
        assertEquals("(4, 6)", pos.move(Direction.Right()).move(Direction.Right()).move(Direction.Right()).toString());
        assertEquals("(4, 5)", pos.move(Direction.Right()).move(Direction.Right()).toString());
        assertEquals("(4, 4)", pos.move(Direction.Right()).toString());
        assertEquals("(4, 3)", pos.toString());

    }

    @Test
    public void testGetters() {
        Position pos = new Position(2, 3);
        assertEquals(2, pos.getRow());
        assertEquals(3, pos.getColumn());
    }

    @Test
    public void testMoving() {
        Position pos = new Position(0, 0);
        assertTrue(pos.move(Direction.Up()).equals(new Position(-1, 0)));
        assertTrue(pos.move(Direction.Right() ).equals(new Position(0, 1)));
        assertTrue(pos.move(Direction.Down()).equals(new Position(1, 0)));
        assertTrue(pos.move(Direction.Left() ).equals(new Position(0, -1)));
        assertTrue(pos.equals(new Position(0, 0)));
    }
}
