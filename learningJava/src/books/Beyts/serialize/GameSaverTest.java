package books.Beyts.serialize;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Эльф", new String[]{"лук", "меч", "кастет"});
        GameCharacter two = new GameCharacter(200, "Тролль", new String[]{"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг", new String[]{"заклинания", "невидимость"});
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\books\\Beyts\\serialize\\Game.ser"))) {
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (IOException e) {
            e.printStackTrace();
        }
        one = null;
        two = null;
        three = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("src\\books\\Beyts\\serialize\\Game.ser"))) {
            one = (GameCharacter) is.readObject();
            two = (GameCharacter) is.readObject();
            three = (GameCharacter) is.readObject();
            System.out.println(one);
            System.out.println(two);
            System.out.println(three);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
