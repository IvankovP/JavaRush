package level_28.bobrArchivator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int readInt() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number:");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("You need to enter a number. Try again");
            return ConsoleHelper.readInt();
        }
    }
}