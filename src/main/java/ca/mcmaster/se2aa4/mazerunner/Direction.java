package ca.mcmaster.se2aa4.mazerunner;

public class Direction {
    private final int dir;
    private static final Direction right = new Direction(0);
    private static final Direction down  = new Direction(1);
    private static final Direction left  = new Direction(2);
    private static final Direction up    = new Direction(3);

    private Direction (int dir) {
        this.dir = dir;
    }

    private Direction fromDir(int dir) {
        if (dir==0) {
            return right;
        } else if (dir==1) {
            return down;
        } else if (dir==2) {
            return left;
        } else if (dir==3) {
            return up;
        } else {
            return null;
        }
    }

    public boolean equals(Direction other) {
        return this.dir == other.dir;
    }

    public Direction turnLeft() {
        return fromDir((dir + 3)%4);
    }

    public Direction turnRight() {
        return fromDir((dir + 1)%4);
    }

    public static Direction Right() {
        return right;
    }
    public static Direction Down() {
        return down;
    }
    public static Direction Left() {
        return left;
    }
    public static Direction Up() {
        return up;
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
