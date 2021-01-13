package level_26.ThreadExceptions.t1;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                } else if (e instanceof Throwable) {
                    System.out.println("Поживем - увидим");
                }
            }
        };
        setUncaughtExceptionHandler(handler);
    }

    public static void main(String[] args) {
    }
}