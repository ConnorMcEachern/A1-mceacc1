package ca.mcmaster.se2aa4.mazerunner;

public class Direction {
    private int dir;

    private Direction (int dir) {
        this.dir = dir;
    }

    public boolean equals(Direction other) {
        return this.dir == other.dir;
    }

    public Direction turnLeft() {
        return new Direction((dir + 3)%4);
    }

    public Direction turnRight() {
        return new Direction((dir + 1)%4);
    }

    public static Direction Right() {
        return new Direction(0);
    }
    public static Direction Down() {
        return new Direction(1);
    }
    public static Direction Left() {
        return new Direction(2);
    }
    public static Direction Up() {
        return new Direction(3);
    }

    public String toString() {
        if (dir==0) {
            return "RIGHT";
        } else if (dir==1) {
            return "DOWN";
        } else if (dir==2) {
            return "LEFT";
        } else if (dir==3) {
            return "UP";
        } else {
            return "ERROR " + dir;
        }
    }
}
