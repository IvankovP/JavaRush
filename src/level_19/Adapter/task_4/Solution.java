package level_19.Adapter.task_4;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:/new.txt"));
        PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
        Person person = adapter.read();
        System.out.println(person);
        person = adapter.read();
        System.out.println(person);
        person = adapter.read();
        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] arr = fileScanner.nextLine().split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(arr[5]),
                    Integer.parseInt(arr[4]) - 1,
                    Integer.parseInt(arr[3]));

            return new Person(arr[1], arr[2], arr[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
