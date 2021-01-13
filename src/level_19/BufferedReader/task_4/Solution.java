package level_19.BufferedReader.task_4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();
        System.setOut(consoleStream);

        String[] strArr = byteArrayOutputStream.toString().split(" ");
        int c = 0, a = Integer.parseInt(strArr[0]), b = Integer.parseInt(strArr[2]);
        String oper = strArr[1];

        if (oper.equals("+")) c = a + b;
        else if (oper.equals("-")) c = a - b;
        else c = a * b;

        System.out.println(String.format("%s %s %s = %s", a, oper, b, c));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = ");
        }
    }
}
