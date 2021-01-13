package level_19.bobr.t12;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Контекстна реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream orig = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPs = new PrintStream(byteArrayOutputStream);
        System.setOut(newPs);

        testString.printSomething();
        System.setOut(orig);

        String[] arr = byteArrayOutputStream.toString().split("\n");
        int count = 1;
        for (String s : arr) {
            System.out.println(s);
            if (count % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
            count++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
