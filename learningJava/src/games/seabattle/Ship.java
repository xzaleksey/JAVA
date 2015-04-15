package games.seabattle;

class Ship {
    static final String ALIVE = "alive";
    static final String DEAD = "dead";
    String status = ALIVE;
    private Cell[] coordinates;
    private int length;

    Ship(int length) {
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        coordinates = new Cell[length];
    }

    public Cell[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Cell[] coordinates) {
        this.coordinates = coordinates;
    }


}
