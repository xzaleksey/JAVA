package games.seabattle;

class Ship {
    static final String ALIVE = "alive";
    static final String DEAD = "dead";
    String status = ALIVE;
    private Cell[] coordinates;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        coordinates = new Cell[length];
    }

    private int length;

    public Cell[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Cell[] coordinates) {
        this.coordinates = coordinates;
    }


    public void setCoordinates(Cell[] coordinates) {
        this.coordinates = coordinates;
    }

    Ship(int length) {
        this.length = length;
    }


}
