package be.dog.d.steven;

import java.util.ArrayList;
import java.util.Collections;

public class RandomList {

    private final ArrayList<Integer> randomList;

    public RandomList(int size) {

        randomList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            randomList.add(i);
        }

        Collections.shuffle(randomList);
    }

    public String readAndRemoveNextRandom(){
        if(randomList.size()>0){
            return randomList.remove(0).toString();
        }
        else return null;
    }

    public String readNextRandomAndShuffle(){
        String next = randomList.get(0).toString();
        Collections.shuffle(randomList);
        return next;
    }
}