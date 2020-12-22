package be.dog.d.steven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomGenerator {

    private ArrayList<Integer> randomList;
    private final int size;
    private final Random r = new Random();
    private int last = 0;

    public RandomGenerator(int size) {
        randomList = getRandomList();
        this.size = size;
    }

    private ArrayList<Integer> getRandomList() {
        randomList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            randomList.add(i);
        }

        Collections.shuffle(randomList);

        return randomList;
    }

    public String readAndRemoveNextRandom() {
        if (randomList.size() <= 0) {
            randomList = getRandomList();
        }
        return randomList.remove(0).toString();
    }

    public String nextRandom() {
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