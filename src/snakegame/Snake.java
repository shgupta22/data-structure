package snakegame;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Cell> snakeBody = new LinkedList<>();

    private Cell head;


    public Snake(Cell initPos) {
        this.head = initPos;
        snakeBody.add(head);
        head.setCellType(CellType.SNAKE_CELL);
    }

    public void grow() {
        snakeBody.add(head);
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to "
                + nextCell.getRow() + " "
                + nextCell.getCol());
        Cell tail = snakeBody.removeLast();
        tail.setCellType(CellType.EMPTY);

        head = nextCell;
        head.setCellType(CellType.SNAKE_CELL);
        snakeBody.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) {
        System.out.println("Going to check for Crash");
        for (Cell cell : snakeBody) {
            if (cell == nextCell) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Cell> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(LinkedList<Cell> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
