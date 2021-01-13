package level_20.Bobr.t7;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
        String fileName = "d:/new.txt";

        Solution sol1 = new Solution(fileName);
        sol1.writeObject("??????????");
        sol1.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true));
        out.writeObject(sol1);
        out.close();
        System.out.println(sol1);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        Solution sol2 = (Solution) inputStream.readObject();
        inputStream.close();
        //System.out.println(sol2.fileName);
        sol2.writeObject("!!!!!!!!!!!!!!");
        sol2.close();
    }
}
