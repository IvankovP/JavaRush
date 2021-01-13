package level_26.ThreadStatus.t1;

/*
Мониторинг состони нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        //TERMINATED
        target.interrupt();
        System.out.println(loggingStateThread.getState());
    }
}

