package net.wikijava.chapter8.polym;

class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }

    @Override
    public String toString() {
        return "Mill{}";
    }
}

class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();

    }

    @Override
    public String toString() {
        return "WheatMill{}";
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        System.out.println(g.getClass());
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}