package net.wikijava.chapter10;

public class Parcel10 {
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);

    }

    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            private String label = dest;

            // Инициализация экземпляра для каждого объекта:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }

            @Override
            public String readLabel() {
                return label;
            }

            private int getCost() {
                return cost;
            }
        };
    }
}
