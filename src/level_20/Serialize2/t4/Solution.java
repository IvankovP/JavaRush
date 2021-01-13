package level_20.Serialize2.t4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //System.out.println(new Solution(4));

        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("d:/new.txt"));

        Solution savedObject = new Solution(10);
        writer.writeObject(savedObject);
        writer.close();
        System.out.println(savedObject);

        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("d:/new.txt"));
        Solution loadedObject = (Solution) reader.readObject();
        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
