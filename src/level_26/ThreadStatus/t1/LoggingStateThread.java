package level_26.ThreadStatus.t1;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
         this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State oldState = null;
        State state = null;
        while (true) {
            state = thread.getState();
            if (oldState != state) {
                System.out.println(state);
                oldState = state;
            }
            if (state == State.TERMINATED) break;
        }
        interrupt();
    }
}
