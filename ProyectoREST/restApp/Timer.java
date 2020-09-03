/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;


public class Timer {
    private final Runnable task;
    private final int n;
    private long sum;
    private long highest = 0;
    private long lowest = 0;

    public Timer(Runnable task, int n) {
        this.task = task;
        this.n = n;
        this.sum = 0;
    }

    public Timer run() {
        for (int i = 0; i < n; i++) {
            long started = System.currentTimeMillis();
            task.run();
            long ended = System.currentTimeMillis();
            long time = ended - started;
            sum += time;
            if (time > highest) highest = time;
            if (time < lowest) lowest = time;
        }
        return this;
    }

    public void report() {
        System.out.println(String.format(
            "Average Execution time: %dms.\nHighest: %dms\nLowest: %dms",
            sum / n,
            highest,
            lowest
        ));
    }
    public void csv() {
        System.out.println(String.format(
                "%d,%d,%d,%d",
                n,
                sum / n,
                highest,
                lowest
        ));
    }
}