package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    StringBuilder pathString;
    Position pos;
    Direction dir;

    public Path(Position start) {
        pathString = new StringBuilder();
        this.pos = start;
        this.dir = Direction.Right();
    }

    public Position getPosition() {
        return this.pos;
    }

    public Direction getDirection() {
        return this.dir;
    }

    public void travel() {
        pathString.append('F');
        pos = getPosition().move(dir);
    }

    public void turnLeft() {
        pathString.append('L');
        dir = dir.turnLeft();
    }

    public void turnRight() {
        pathString.append('R');
        dir = dir.turnRight();
    }

    public String toString() {
        return pathString.toString();
    }
}
