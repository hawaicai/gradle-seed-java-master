package com.jiker.keju.generator;

import java.util.Random;

public class RandomIntGenerator {
    public int nextInt() {
        return new Random().nextInt(10);
    }
}
