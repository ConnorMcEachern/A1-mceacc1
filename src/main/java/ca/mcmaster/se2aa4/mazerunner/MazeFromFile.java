package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MazeFromFile implements MazeBuilder{
    private boolean[][] walls;

    public MazeFromFile file(File maze_file) throws java.io.IOException {
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
        return this;
    }

    @Override
    public Maze build() {
        return new Maze(walls);
    }
}
