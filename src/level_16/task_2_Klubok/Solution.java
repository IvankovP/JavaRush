package level_16.task_2_Klubok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        @Override
        public void run() {
            while (!this.isInterrupted()) {}
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class ThreadFive extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int i = 0, sum = 0;
                String s;
                while (true) {
                    if ((s = reader.readLine()).equals("N")) break;
                    i = Integer.parseInt(s);
                    sum += i;
                }
                reader.close();
                System.out.println(sum);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


}
