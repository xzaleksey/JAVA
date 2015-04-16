package games.seabattle;

import java.util.Random;

class Field {
    static final int COUNT = 10;
    static char[] chars = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к'};
    static int[] shipsTypes = {1, 2, 3, 4};// 4 типа(по длине) с количеством кораблей, где 0 индекс - длина корабля длина - индекс.
    private static Random rnd = new Random();
    Ship[] ships = new Ship[COUNT]; //10 кораблей массив
    Cell[][] cells = new Cell[COUNT][COUNT];

    Field() { // создание поля

        for (int i = 0; i < COUNT; i++)//строка
            for (int j = 0; j < COUNT; j++) {//столбец
                cells[i][j] = new Cell();
                cells[i][j].setRow(i);
                cells[i][j].setColumn(chars[j]);
            }
        fillWithShips();
    }

    public static int[] swap(int[] array, int index1, int index2) {//метод смены элементов в массиве
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    void fillWithShips() {//создание кораблей на поле
        int counter = 0;
        for (int i = 0; i < shipsTypes.length; i++) {// перебираем типы
            for (int j = 0; j < shipsTypes[i]; j++) {
                ships[counter] = new Ship(shipsTypes.length - i); //задаем длину корабля и создаем его
                putShip(ships[counter]);
                counter++;
            }
        }
    }

    boolean checkCell(Ship ship, int row, int col) {// проверка на подходящую клетку
        try {
            return cells[row][col].getShip() == null || cells[row][col].getShip() == ship;
        } catch (Exception e) {
            return true;
        }
    }

    boolean checkAdjustCells(Ship ship, int row, int col) {//проверка соседних клеток на корабли
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!checkCell(ship, row + i, col + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    void putShip(Ship ship) {

        int startCellRow = rnd.nextInt(COUNT);// получаем параметрын начальной клетки
        int startCellColumn = rnd.nextInt(COUNT);
        if (checkCell(ship, startCellRow, startCellColumn)) {
            Boolean dir;
            //  Cell coordinates[] = ship.getCoordinates(); //массив клеток корабля
            dir = getDirection(startCellRow - 1, startCellColumn - 1, ship.getLength(), ship); //в какую сторону будем корабль от начальной клетки ставить
            if (!dir) {//если хоть 1 направление подошло
                putShip(ship);
            }

        } else {
            putShip(ship);
        }
    }

    Boolean getDirection(int row, int col, int length, Ship ship) { //возвращаем подходящее направление для расстановки 0-лево, 1-верх, 2-право, 3-вниз, 4 -ни одно не подошло.
        int[] dir = {0, 1, 2, 3};//индексы для массива результатов
        int counter = dir.length - 1;
        while (counter > 0) { //перемешиваем массив
            int index = rnd.nextInt(counter + 1);
            dir = swap(dir, index, counter);
            --counter;
        }
        for (int d : dir) {
            if (checkAndSetDir(row, col, length, d, ship)) {
                return true;
            }
        }
        return false;
    }

    Boolean checkAndSetDir(int row, int col, int length, int d, Ship ship) {
        int incRow = 0;//i строка
        int incCol = 0;//j столбец
        switch (d) {
            case 0: //влево
                incCol = -1;
                break;
            case 1://вверх
                incRow = -1;
                break;
            case 2://вправо
                incCol = 1;
                break;
            case 3:
                incRow = 1;//вниз
        }

        for (int i = 0; i < length; i++) {//проверка на добавление корабля
            try {
                cells[row + i * incRow][col + i * incCol].getColumn(); //проверка на край
                if (!checkAdjustCells(ship, row + i * incRow, col + i * incCol)) {  //проверка соседних на корабли
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        Cell[] coordinates = ship.getCoordinates();
        for (int i = 0; i < length; i++) {// создание корабля
            cells[row + i * incRow][col + i * incCol].setShip(ship);
            coordinates[i] = cells[row + i * incRow][col + i * incCol];
        }
        ship.setCoordinates(coordinates);
        return true;
    }
}
