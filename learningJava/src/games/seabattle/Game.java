package games.seabattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Game {
    Field field = new Field();
    private int numOfShots = 0;

    Game() {

    }

    void input() throws IOException {
        System.out.println("Стреляй!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (checkInput(input.toLowerCase())) {
            field.cells[getInt(input.substring(1)) - 1][getInt(input.charAt(0))].getColumn(); //обращение к введенной пользователем клетке
        } else {
            output("Ошибка при вводе. Формат ввода: а1");
            input();
        }
    }

    void output(String s) {
        System.out.println(s);
    }

    int getInt(String s) {// возвращает число
        return Integer.valueOf(s);
    }

    int getInt(char c) {// возвращает число
        return (int) c - 1072;
    }

    Boolean checkInput(String s) {// формат а1 б2 а10
        if (s.length() == 2 || s.length() == 3) {//ввод из 2 или 3 букв
            if ((int) s.charAt(0) > 1071 && (int) s.charAt(0) < 1083) { //проверка на буквы а-к
                try {
                    int i = Integer.parseInt(s.substring(1));//проверка на число
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    String shot() {

        numOfShots++;
        return null;
    }
}
