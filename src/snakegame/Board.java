package snakegame;

public class Board {
    private final int ROW_COUNT, COL_COUNT;

    private Cell[][] cells;

    public Board(int rowCount, int colCount) {
        this.ROW_COUNT = rowCount;
        this.COL_COUNT = colCount;
        cells = new Cell[rowCount][colCount];

        for(int i=0; i < ROW_COUNT; i++) {
            for (int j=0;j<COL_COUNT;j++) {
                cells[i][j]=new Cell(i, j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
        System.out.println("Going to generate food");
        int row, col;
        while (true) {
            row = (int) (Math.random() * ROW_COUNT);
            col = (int) (Math.random() * COL_COUNT);

            if (!cells[row][col].getCellType().equals(CellType.SNAKE_CELL)) break;
        }
        cells[row][col].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row + " " + col);
    }
}
