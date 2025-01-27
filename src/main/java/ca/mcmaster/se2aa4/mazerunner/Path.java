package ca.mcmaster.se2aa4.mazerunner;

import java.util.LinkedList;
import java.util.List;

public class Path {
    List<Position> path;

    public Path(Position start) {
        path = new LinkedList<Position>();
        path.add(start);
    }

    public Position getPosition() {
        return path.getLast();
    }

    public void travel(Direction dir) {
        path.add(path.getLast().move(dir));
    }

    public String toString() {
        StringBuffer pathString = new StringBuffer();
        Direction facing = Direction.Right();
        int i = 1;
        while(i<path.size()) {
            Position current = path.get(i-1);
            Position next = path.get(i);
            if (current.move(facing).equals(next)) {
                pathString.append("F");
                i++;
            } else {
                pathString.append("R");
                facing = facing.turnRight();
            }
        }
        return pathString.toString();
    }
}
