package games.seabattle;

class Cell {
    static final String NEW = "new";
    static final String BUSY = "busy";
    static final String SHOT = "shot";
    private String status = NEW;
    private Ship ship;
    private int row;
    private char column;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
