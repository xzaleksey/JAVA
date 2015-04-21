package net.wikijava.chapter9.interfaces;

//: interfaces/HorrorShow.java
// Расширение интерфейса с помощью наследования

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {
        System.out.println(this);
    }

    @Override
    public void destroy() {
        System.out.println(this);
    }
}

class VeryBadVampire implements Vampire {
    @Override
    public void menace() {
        System.out.println(this);
    }

    @Override
    public void destroy() {
        System.out.println(this);
    }

    @Override
    public void kill() {
        System.out.println(this);
    }

    @Override
    public void drinkBlood() {
        System.out.println(this);
    }
}

public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}