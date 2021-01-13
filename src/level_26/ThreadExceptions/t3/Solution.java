package level_26.ThreadExceptions.t3;

import java.util.LinkedList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        getException(e);
    }

    public void getException(Throwable cause) {
        if (cause.getCause() == null) {
            System.out.println(cause);
        } else {
            getException(cause.getCause());
            System.out.println(cause);
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Throwable e) {
            getException(e);
        }
    }
    public void getException(Throwable cause) {
        if (cause.getCause() == null) {
            System.out.println(cause);
        } else {
            getException(cause.getCause());
            System.out.println(cause);
        }
    }

}