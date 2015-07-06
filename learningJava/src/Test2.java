import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Character> characters = new ArrayList<>();
        characters.add('m');
        characters.add('a');
        characters.add('k');
        characters.add('e');
        characters.add(characters.remove(0));
        System.out.println(characters);
    }

}