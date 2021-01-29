package level_29.threadPriority.t2;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger countThread = new AtomicInteger(Thread.MIN_PRIORITY);

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priority();
    }

    public MyThread() {
        super();
        priority();
    }

    public MyThread(Runnable target) {
        super(target);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priority();
    }

    public MyThread(String name) {
        super(name);
        priority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priority();
    }

    private void priority() {
        if (countThread.get() > Thread.MAX_PRIORITY) countThread.set(Thread.MIN_PRIORITY);
        if (this.getThreadGroup().getMaxPriority() == 1) this.setPriority(countThread.getAndIncrement());
            else this.setPriority(Math.min(countThread.getAndIncrement(), this.getThreadGroup().getMaxPriority()));
    }
}
