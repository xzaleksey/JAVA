package ru.geekbrains.practise.highcompress;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static net.mindview.util.Print.print;

public class HighCompress {
    static final char[] CHARS = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', ' '};

    public static void main(String[] args) {
        Random rnd = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) { //создание рандомной строки
            stringBuilder.append(CHARS[rnd.nextInt(CHARS.length)]);
        }
        System.out.println(stringBuilder);
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < CHARS.length; i++) { //подготовка hashmap
            map.put(CHARS[i], new ArrayList<>(100));
        }
        char[] chars = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {//занесение данных в hashmap
            map.get(chars[i]).add(i);
        }

        try (FileChannel fc = new FileOutputStream("text1.txt").getChannel()) {
            fc.write(ByteBuffer.wrap(stringBuilder.toString().getBytes()));
            fc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("text.out"))) {
            o.writeObject(map);
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("Saving object:");
        HashMap<Integer, Character> result = new HashMap<>();
        for (int i = 0; i < CHARS.length; i++) {
            for (int j = 0; j < map.get(CHARS[i]).size(); j++) {
                result.put(map.get(CHARS[i]).get(j), CHARS[i]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}
