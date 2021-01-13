package level_28.waitNotify.t3;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch
*/

public class Solution {
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.await();
        latch.countDown();

            retrieveValue();

            isWaitingForValue = false;
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}
