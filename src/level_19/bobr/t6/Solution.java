package level_19.bobr.t6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s = "";

        while ((s = reader.readLine()) != null) {
            String[] strArr = s.split(" ");
            String name = "";
            int day, month, year;

            if (strArr.length > 4) {
                for (int i = 0; i < strArr.length - 3; i++) {
                    name += strArr[i] + " ";
                }
            } else name = strArr[0];

            name = name.trim();
            day = Integer.parseInt(strArr[strArr.length - 3]);
            month = Integer.parseInt(strArr[strArr.length - 2]);
            year = Integer.parseInt(strArr[strArr.length - 1]);

            Calendar calendar = new GregorianCalendar(year, month - 1, day);
            PEOPLE.add(new Person(name, calendar.getTime()));
        }
        reader.close();

        for (Person p : PEOPLE) System.out.println(p.getName() + " " + p.getBirthDate());
    }
}
