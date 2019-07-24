package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a Java or C program that performs runs of the following process scheduling algorithms:
 * • First-come first-served (FCFS) [non-preemptive]
 * • Shortest job first (SJF) [non-preemptive]
 * • Shortest remaining time (SRT) [preemptive]
 * • Round robin (RR) [preemptive]
 * • Highest priority first (HPF) [both non-preemptive and preemptive]
 *
 * Run each algorithm 5 times to get averages for the statistics below
 *
 * Each Above algorithm will run for 150 quanta (time slices)
 * Before each run, generate a set of simulated processes
 */
public class Main {

    /*
    the processors are allowed to spend finite chunks of time (quanta) per process.
    Note that the quantum has nothing to do with task priority,
    it’s simply the amount of time the CPU will spend on the task.
    Every time the CPU switches to a new process,
    there’s what’s called a context switch (en.wikipedia.org/wiki/Context_switch),
    which is computationally expensive.
    Obviously, we need to avoid excessive context switching but still maintain the illusion of concurrency.
     */

    private int[] time_slices = new int[150];

    private ArrayList<LocalProcess> process_queue = new ArrayList<>();

    public static void main(String[] args){
        Main main = new Main();
        main.startProcessScheduler();


    }

    public void startProcessScheduler(){

        // Run each algorithm for 150 quanta (time slices), labeled 0 through 149
        for (int i = 0; i < 150; i++){
            time_slices[i] = i;
        }

        // Generate set of N number processes
        int N = 20;
        process_queue = generateSortedSetOfSimulatedProcesses(20);



    }



    public ArrayList<LocalProcess> generateSortedSetOfSimulatedProcesses(int N){

        ArrayList<LocalProcess> localProcesses = new ArrayList<>();

        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        for (int i = 0; i < N; i++) {

            char name = (char) ('A'+i);
            float at = randomValueGenerator.getRandomArrivalTime();
            float expectedTotalRunTime = randomValueGenerator.getRandomTotalRunTime();
            int priority = randomValueGenerator.getRandomPriority();

            LocalProcess localProcess = new LocalProcess(name, at, expectedTotalRunTime, priority);

            localProcesses.add(localProcess);
        }

        Collections.sort(localProcesses);
        return localProcesses;
    }


}
