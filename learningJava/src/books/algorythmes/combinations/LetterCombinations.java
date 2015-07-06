package books.algorythmes.combinations;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class LetterCombinations {
    static HashMap<Long, ArrayList<ArrayList<Character>>> hashMap = new HashMap<>();
    static HashSet<String> strings = new HashSet<>();

    public static void main(String[] args) {
        // getCombinations("dog");
        long before = System.currentTimeMillis();
        getCombinations2("mothe");
        long after = System.currentTimeMillis();
        long diff = after - before;
        System.out.println("seccond : " + (float) diff / 1000);
    }

    public static void getCombinations(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.print(s.substring(i, j));
                System.out.print(" ");
            }
        }
    }

    public static void getCombinations2(String s) {
        if (s.length() < 2) {
            System.out.println(s);
            return;
        }
        ArrayList<Character> characters = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) { // подготовка Arraylist
            characters.add(s.charAt(i));
        }
        outLetters(characters); // Все комбинации из 1 символа
        getAllCombinations("", characters);
        callRecursive(characters);
        //  System.out.println(hashMap);
        if (hashMap.size() > 0) {
            for (ArrayList<ArrayList<Character>> arrayLists : hashMap.values()) {
                for (ArrayList<Character> arrayList : arrayLists) {
                    getAllCombinations("", arrayList);
                }
            }

        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")))) {
            for (String string : strings) {
                writer.write(string);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outLetters(ArrayList<Character> chars) {
        TreeSet<Character> characters = new TreeSet<>();
        for (Character aChar : chars) {
            characters.add(aChar);
        }
        for (Character character : characters) {
            strings.add("" + character);
        }
    }

    public static void callRecursive(ArrayList<Character> characters) {

        if (characters.size() > 2) {
            ArrayList<ArrayList<Character>> arrayLists;
            for (int i = 0; i < characters.size(); i++) {
                characters.add(characters.remove(0));
                ArrayList<Character> tempChars = (ArrayList<Character>) characters.clone();
                tempChars.remove(0);
                long hash = getHash(tempChars);
                outer:
                if (hashMap.containsKey(hash)) {// если хэш нашелся
                    arrayLists = hashMap.get(hash);

                    for (ArrayList<Character> arrayList : arrayLists) {
                        if (arrayList.containsAll(tempChars)) {
                            break outer;// если нашли такой же массив выходим
                        }
                    }
                    arrayLists.add(tempChars);
                } else { //если хэш новый
                    arrayLists = new ArrayList<>();
                    arrayLists.add(tempChars);
                    hashMap.put(hash, arrayLists);
                }
                callRecursive(tempChars);
            }
        }
    }

    public static long getHash(ArrayList<Character> chars) {
        long l = 0;
        for (Character aChar : chars) {
            l += aChar;
        }
        return l;
    }

    public static void getAllCombinations(String s, ArrayList<Character> characters) {
        if (characters.size() > 2) {
            for (int i = 0; i < characters.size(); i++) {
                characters.add(characters.remove(0));
                ArrayList<Character> temp = (ArrayList<Character>) characters.clone();
                getAllCombinations(s + temp.remove(0), temp);
            }
            return;
        }
        strings.add(s + characters.get(0) + characters.get(1));
        strings.add(s + characters.get(1) + characters.get(0));

//        System.out.println(s + characters.get(0) + characters.get(1));
//        System.out.println(s + characters.get(1) + characters.get(0));
    }
}
