package net.wikijava.chapter12;

public class Cleanup {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        try {
            InputFile in = new InputFile("src\\net\\wikijava\\chapter12\\Cleanup.java");
            try {
                String s;
                while ((s = in.getLine()) != null)
                    System.out.println(s);
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}