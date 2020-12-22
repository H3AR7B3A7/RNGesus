package be.dog.d.steven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomGenerator {

    private final ArrayList<Integer> randomList;
    private final int size;
    private final Random r = new Random();
    private int last = 0;

    public RandomGenerator(int size) {

        randomList = new ArrayList<>();
        this.size = size;

        for (int i = 1; i <= size; i++) {
            randomList.add(i);
        }

        Collections.shuffle(randomList);
    }

    public String readAndRemoveNextRandom() {
        if (randomList.size() > 0) {
            return randomList.remove(0).toString();
        } else return null;
    }

    public String readNextRandomAndShuffle() {
        int next = r.nextInt(size) + 1;
        if (last != next) {
            last = next;
            return String.valueOf(next);
        } else {
            if (next + 1 < size) {
                last = next + 1;
                return String.valueOf(next + 1);
            } else {
                last = 1;
                return "1";
            }
        }
    }
}