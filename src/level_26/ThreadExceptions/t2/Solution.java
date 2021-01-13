package level_26.ThreadExceptions.t2;

import java.util.TimerTask;

/*
Вооружаемс до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < t.getName().length(); i++) {
                    buffer.append("*");
                }
                System.out.println(e.getMessage().replaceAll(t.getName(), buffer.toString()));
            }
        };
    }

    public void run() {
        try {
            original.run();
            throw new NullPointerException();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Solution(new TimerTask() {
            @Override
            public void run() {

            }
        }).run();
    }
}