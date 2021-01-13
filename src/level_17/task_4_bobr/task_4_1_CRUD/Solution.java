package level_17.task_4_bobr.task_4_1_CRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодн родилс    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодн родилс    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String parameters = args[0];

        if (parameters.equalsIgnoreCase("-c")) {
            try {
                String name = args[1];
                Date bd = dateFormat.parse(args[3]);

                Person person = null;

                if (args[2].equalsIgnoreCase("м")) person = Person.createMale(name, bd);
                else if (args[2].equalsIgnoreCase("ж")) person = Person.createFemale(name, bd);

                if (person != null ) {
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }

            } catch (ParseException e) {
                System.out.println("Sorry, parsing is fail. Try again");
            }
        }
        else if (parameters.equalsIgnoreCase("-u")) {
            try {
                int id = Integer.parseInt(args[1]);

                Person findPerson = allPeople.get(id);
                findPerson.setName(args[2]);

                if (args[3].equalsIgnoreCase("м")) findPerson.setSex(Sex.MALE);
                else if (args[3].equalsIgnoreCase("ж")) findPerson.setSex(Sex.FEMALE);

                findPerson.setBirthDate(dateFormat.parse(args[4]));

                System.out.println(String.format("Person with %s has been updated", id));

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sorry, the person with this ID was not found. Try again");
            } catch (ParseException e) {
                System.out.println("Sorry, parsing is fail. Try again");
            }
        }
        else if (parameters.equalsIgnoreCase("-d")) {
            try {
                int id = Integer.parseInt(args[1]);
                Person findPerson = allPeople.get(id);

                findPerson.setName(null);
                findPerson.setBirthDate(null);
                findPerson.setSex(null);

                System.out.println(String.format("Person with ID %s has been delete", id));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sorry, the person with this ID was not found. Try again");
            }
        }
        else if (parameters.equalsIgnoreCase("-i")) {
            try {
                Person findPerson = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat dateFormatInfo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(findPerson.getName() + " " +
                        (findPerson.getSex() == Sex.FEMALE ? "ж" : "м") + " " +
                        dateFormatInfo.format(findPerson.getBirthDate()));

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sorry, the person with this ID was not found. Try again");
            }
        }
    }
}
