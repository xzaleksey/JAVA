package books.algorythmes.combinations;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinations {
    public static void main(String[] args) {
        // getCombinations("dog");
        getCombinations2("make");
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
        for (int i = 0; i < s.length(); i++) { // подготовка
            characters.add(s.charAt(i));
        }
        outLetters(characters);
        getAllCombinations("", characters);
        HashMap<Long, ArrayList<ArrayList<Character>>> hashMap = callRecursive(characters, new HashMap<>());
        if (hashMap != null) {
            for (ArrayList<ArrayList<Character>> arrayLists : hashMap.values()) {
                for (ArrayList<Character> arrayList : arrayLists) {
                    getAllCombinations("", arrayList);
                }
            }
        }

    }

    public static void outLetters(ArrayList<Character> chars) {
        for (Character aChar : chars) {
            System.out.println(aChar);
        }
    }

    public static HashMap<Long, ArrayList<ArrayList<Character>>> callRecursive(ArrayList<Character> characters, HashMap<Long, ArrayList<ArrayList<Character>>> hashMap) {

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
                callRecursive(tempChars, hashMap);
            }
            return hashMap;
        }
        return null;
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
        System.out.println(s + characters.get(0) + characters.get(1));
        System.out.println(s + characters.get(1) + characters.get(0));
    }
}
