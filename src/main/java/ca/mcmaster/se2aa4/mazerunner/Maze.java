package ca.mcmaster.se2aa4.mazerunner;

public class Maze {

    private final boolean[][] walls;

    public Maze (boolean[][] walls) {
        this.walls = walls;
    }

    public boolean isWallAt(Position position) {
        return walls[position.getRow()][position.getColumn()];
    }

    public int getHeight() {
        return walls.length;
    }

    public int getLength() {
        return walls[0].length;
    }

    public Position startingPosition() {
        for (int row = 0; row<getHeight(); row++) {
            if (!walls[row][0]) {
                return new Position(row, 0);
            }
        }
        return null;
    }
}
