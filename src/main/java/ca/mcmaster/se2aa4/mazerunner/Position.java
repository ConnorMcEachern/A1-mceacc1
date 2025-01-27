package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int row;
    private int column;

    public Position (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean equals(Position other) {
        return this.row == other.row && this.column == other.column;
    }

    public Position move(Direction dir) {
        Position next = new Position(this.row, this.column);
        if (dir.equals(Direction.Right())) {
            next.column += 1;
        } else if (dir.equals(Direction.Left())) {
            next.column -= 1;
        } else if (dir.equals(Direction.Up())) {
            next.row -= 1;
        } else if (dir.equals(Direction.Down())) {
            next.row += 1;
        }
        return next;
    }

    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }
}
