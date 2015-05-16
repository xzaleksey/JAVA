package net.wikijava.chapter10;

class Parcel4 {
    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        System.out.println(d.getClass().getName());
        System.out.println(d.readLabel());
        // Запрещено - нет доступа к private-классу:
        //! Parcel4.PContents pc = p.new PContents();
    }
}
