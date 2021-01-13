package level_27.Concurrency.t2;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        try {
            while (!currentThread.isInterrupted()) {
                int count = 1;
                while (true) {
                    map.put(String.valueOf(count), "Some text for " + count);
                    count++;
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
