package books.Beyts.serialize;

import java.io.Serializable;
import java.util.Arrays;

public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "power=" + power +
                ", type='" + type + '\'' +
                ", weapons=" + Arrays.toString(weapons) +
                '}';
    }

    public String getWeapons() {
        String weaponlist = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponlist += weapons[i] + " ";
        }
        return weaponlist;
    }
}
