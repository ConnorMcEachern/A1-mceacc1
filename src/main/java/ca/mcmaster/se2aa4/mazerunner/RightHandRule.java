package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule implements MazeSolver {
    
    public Path getPath(Maze maze) {
        Path path = new Path(maze.startingPosition());
        while (path.getPosition().getColumn() != maze.getLength()-1) {
            if (!maze.isWallAt(path.getPosition().move(path.getDirection().turnRight()))) {
                path.turnRight();
                path.travel();
            } else if (!maze.isWallAt(path.getPosition().move(path.getDirection()))) {
                path.travel();
            } else {
                path.turnLeft();
            }
        }
        return path;
    }
    
}

