package level_20.Serialize2.t5;

import java.io.*;

/*
Переопределение сериализации
*/
public class Solution implements Runnable, Serializable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        while (true) System.out.println(1);
    }

    /**
     * Переопределем сериализацию.
     * Дл этого необходимо объвить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализаци/десериализаци пойдет по нашему сценарию :)
     */

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {
        new Solution(50);
    }
}