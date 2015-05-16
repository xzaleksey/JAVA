package net.wikijava.chapter10;

// Вложенные (статические внутренние) классы
public class Parcel11 {
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }

    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination
            implements Destination {
        static int x = 10;
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        // Вложенные классы могут содержать другие статические элементы;
        public static void f() {
        }

        @Override
        public String readLabel() {
            return label;
        }

        static class AnotherLevel {
            static int x = 10;

            public static void f() {
            }
        }
    }
}