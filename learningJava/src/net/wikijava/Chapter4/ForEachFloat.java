package net.wikijava.Chapter4;

import java.util.Random;

/**
 * Created by ruaval on 09.04.2015.
 */
public class ForEachFloat {
    public ForEachFloat() {
        Random rand = new Random();
        float f[] = new float[10];
        for (int i = 0; i < 10; i++)
            f[i] = rand.nextFloat();
        for (float x : f)
            System.out.println(x);

    }
}
