package games.seabattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Game {
    Field field = new Field();
    private int numOfShots = 0;
    private int numOfSuccesses = 0;
    private int shipCount = Field.COUNT;
    Game() {
        int counter = 1;
        for (Ship i : field.ships) {
            Cell[] cells = i.getCoordinates();
            System.out.println("Корабль:" + counter);
            counter++;
            for (Cell c : cells) {
                System.out.println("номер строки: " + c.getRow() + " номер столбца: " + ((int) c.getColumn() - 1072));
            }
        }

    }

    void test() {
        System.out.println("   а б в г д е ж з и к");
        for (int i = 0; i < Field.COUNT; i++) {
            if (i == 9) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print((i + 1) + "  ");
            }
            for (int j = 0; j < Field.COUNT; j++) {
                if (field.cells[i][j].getShip() != null) {
                    if (!field.cells[i][j].getStatus()) {
                        System.out.print("х" + " ");
                    } else
                        System.out.print("|" + " ");
                } else {
                    if (field.cells[i][j].getStatus()) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print("*" + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    void input() throws IOException {
        test();
        output("Стреляй!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (checkInput(input.toLowerCase())) {
            shot(field.cells[getInt(input.substring(1)) - 1][getInt(input.charAt(0))]); //обращение к введенной пользователем клетке
        } else {
            output("Ошибка при вводе. Формат ввода: а1");
            input();
        }
    }

    void start() {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void output(String s) {
        System.out.println(s);
    }

    int getInt(String s) {// возвращает число
        return Integer.valueOf(s);
    }

    int getInt(char c) {// возвращает число
        if ((int) c < 1081) {//буква й
            return (int) c - 1072;
        } else {
            return (int) c - 1073;
        }
    }

    Boolean checkInput(String s) {// формат а1 б2 а10
        if (s.length() == 2 || s.length() == 3) {//ввод из 2 или 3 букв
            if ((int) s.charAt(0) > 1071 && (int) s.charAt(0) < 1083) { //проверка на буквы а-к
                try {
                    int i = Integer.parseInt(s.substring(1));//проверка на число

                    return i <= 10;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    void shot(Cell cell) {
        if (cell.getStatus() == Cell.SHOT) {
            output("Вы уже стреляли туда!");
        } else {
            cell.setStatus(Cell.SHOT);
            if (cell.getShip() == null) {
                output("Мимо");
            } else {
                cell.getShip().popadanie();
                numOfSuccesses++;
                if (cell.getShip().checkStatus()) {
                    output("Попал!");
                } else {
                    output("Убил");
                    shipCount--;
                }
            }
            numOfShots++;
        }
        if (shipCount == 0) {
            output("Победа!");
            output("Вы сделали " + numOfShots + " выстрелов!");
            output("Вы сделали " + numOfSuccesses + " успешных выстрелов!");
        } else {
            try {
                input();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
