package ca.mcmaster.se2aa4.mazerunner;

public class Solver {
    Maze maze;

    public Solver (Maze maze) {
        this.maze = maze;
    }

    public Path getPath() {
        Path path = new Path(maze.startingPosition());
        Direction dir = Direction.Right();
        while (path.getPosition().getColumn() != maze.getLength()-1) {
            if (!maze.isWallAt(path.getPosition().move(dir.turnRight()))) {
                dir = dir.turnRight();
                path.travel(dir);
            } else if (!maze.isWallAt(path.getPosition().move(dir))) {
                path.travel(dir);
            } else {
                dir = dir.turnLeft();
            }
            
        }
        return path;
    }
    
}

