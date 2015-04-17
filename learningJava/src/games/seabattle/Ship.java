package games.seabattle;

class Ship {
    static final boolean ALIVE = true;
    static final boolean DEAD = false;
    private Cell[] coordinates;//занимаемые клетки
    private int length;//длина
    private int lifes;//жизни
    Ship(int length) {
        setLength(length);
    }

    boolean checkStatus() {
        if (lifes == 0) {
            return DEAD;
        } else {
            return ALIVE;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        coordinates = new Cell[length];
        lifes = length;
    }

    void popadanie() {
        lifes -= 1;
    }

    public Cell[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Cell[] coordinates) {
        this.coordinates = coordinates;
    }


}
