package ca.mcmaster.se2aa4.mazerunner;

public class Checker {
    public boolean checkPath(Maze maze, String pathString) {
        Path path = new Path(maze.startingPosition());
        for (char c : pathString.toCharArray()) {
            if (c == 'F') {
                path.travel();
            } else if (c == 'R') {
                path.turnRight();
            } else if (c == 'L') {
                path.turnLeft();
            }
            if (maze.isWallAt(path.getPosition())) {
                return false;
            }
        }

        if (path.getPosition().getColumn() == maze.getLength()-1) {
            return true;
        } else {
            return false;
        }
    }
}
