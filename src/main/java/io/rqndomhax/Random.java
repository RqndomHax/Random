package io.rqndomhax;

import java.awt.*;

public class Random {

    public final int seed;

    public Random(int seed) {
        this.seed = seed;
    }

    public Random() {
        this.seed = generateRandomSeed();
    }

    private int generateRandomSeed() {
        int seed = nextInt((int) System.nanoTime());

        seed += nextInt(MouseInfo.getPointerInfo().getLocation().x);
        seed += nextInt(MouseInfo.getPointerInfo().getLocation().y);
        return seed;
    }

    private int nextInt(int seed) {
        int loops = 0;
        int number = seed;
        int current = number;

        while (current > 10) {

            if (current % 2 == 0) {
                current /= 2;
                number += current;
            }

            else {
                current = (current * 3) + 1;
                number += current;
            }

            current = Math.abs(current);

            current += ++loops;
        }

        return Math.abs(number);
    }

    int nextInt() {
        return nextInt(this.seed);
    }

}
