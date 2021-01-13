package level_26.ThreadYield.t2;

/*
Первый закон Финэйгла: если эксперимент удалс, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);

        }
    }

    public static void main(String[] args) {
        new Thread(new YieldRunnable(5)).start();
        new Thread(new YieldRunnable(10)).start();
        new Thread(new YieldRunnable(15)).start();
        new Thread(new YieldRunnable(20)).start();
    }
}

