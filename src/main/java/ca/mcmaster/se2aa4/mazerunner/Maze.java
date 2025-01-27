package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {

    private boolean[][] walls;

    public Maze (String maze_file) throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new FileReader(maze_file));
        
        StringBuffer chars = new StringBuffer();
        chars.append(reader.readLine());
        int columns = chars.length();
        int rows = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            chars.append(line);
            rows++;
        }

        walls = new boolean[rows][columns];
        for (int row = 0; row<rows; row++) {
            for (int col = 0; col<columns; col++) {
                char c = chars.charAt(row*columns+col);
                walls[row][col] = (c == '#');
            }
        }
        
        reader.close();
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
