package games.seabattle;

class Cell {
    static final boolean NEW = true;
    static final boolean SHOT = false;
    private boolean status = NEW;
    private Ship ship;
    private int row;
    private char column;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }


}
