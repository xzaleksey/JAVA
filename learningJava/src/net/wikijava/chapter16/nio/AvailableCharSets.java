package net.wikijava.chapter16.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets =
                Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            printnb(csName);
            Iterator aliases =
                    charSets.get(csName).aliases().iterator();
            if (aliases.hasNext())
                printnb(": ");
            while (aliases.hasNext()) {
                printnb(aliases.next());
                if (aliases.hasNext())
                    printnb(", ");
            }
            print();
        }
    }
}