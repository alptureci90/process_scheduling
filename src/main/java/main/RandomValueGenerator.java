package main;

import java.util.Random;

/**
 * Under Development
 */

public class RandomValueGenerator {

    private static long seed = 5L;

    public static void main(String[] args){
        Random rnd = new Random(seed);
        for(int i=0;i<5;i++){
            System.out.println(rnd.nextInt(100));
        }
    }

    public float getRandomArrivalTime(){
        Random r = new Random();
        float min = 0;
        float max = 149;
        r.setSeed(seed);
        return r.nextFloat() * (max - min) + min;

    }

    public float getRandomTotalRunTime(){
        Random r = new Random();
        float min = 1;
        float max = 10;
        r.setSeed(seed);
        return r.nextFloat() * (max - min) + min;
    }

    public int getRandomPriority(){
        Random r = new Random();
        r.setSeed(seed);
        return r.nextInt(4);
    }

}
