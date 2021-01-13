package level_17.task_4_bobr.task_4_2_CRUD2;

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

        switch (args[0]) {
            case ("-c"):
                try {
                    for (int i = 1; i < args.length; i += 3) {

                        String name = args[i];
                        Date bd = dateFormat.parse(args[i+2]);

                        Person person = null;

                        if (args[i+1].equalsIgnoreCase("м")) person = Person.createMale(name, bd);
                        else if (args[i+1].equalsIgnoreCase("ж")) person = Person.createFemale(name, bd);

                        if (person != null) {
                            synchronized (allPeople) {
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                        }
                    }

                } catch (ParseException e) {
                    System.out.println("Sorry, parsing is fail. Try again");
                }
                break;

            case("-u"):
                try {
                    for (int i = 1; i < args.length; i += 4) {

                            int id = Integer.parseInt(args[i]);

                            synchronized (allPeople) {
                                Person findPerson = allPeople.get(id);
                                findPerson.setName(args[i + 1]);

                                if (args[i + 2].equalsIgnoreCase("м")) findPerson.setSex(Sex.MALE);
                                else if (args[i + 2].equalsIgnoreCase("ж")) findPerson.setSex(Sex.FEMALE);

                                findPerson.setBirthDate(dateFormat.parse(args[i + 3]));
                            }

                            System.out.println(String.format("Person with %s has been updated", id));
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorry, the person with this ID was not found. Try again");
                } catch (ParseException e) {
                    System.out.println("Sorry, parsing is fail. Try again");
                }
                break;

            case("-d"):
                try {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);

                        synchronized (allPeople) {
                            Person findPerson = allPeople.get(id);
                            findPerson.setName(null);
                            findPerson.setBirthDate(null);
                            findPerson.setSex(null);
                        }

                        System.out.println(String.format("Person with ID %s has been delete", id));
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorry, the person with this ID was not found. Try again");
                }
                break;

            case("-i"):
                try {
                    for (int i = 1; i < args.length; i++) {
                        synchronized (allPeople) {
                            Person findPerson = allPeople.get(Integer.parseInt(args[i]));
                            SimpleDateFormat dateFormatInfo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(findPerson.getName() + " " +
                                    (findPerson.getSex() == Sex.FEMALE ? "ж" : "м") + " " +
                                    dateFormatInfo.format(findPerson.getBirthDate()));
                        }
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorry, the person with this ID was not found. Try again");
                }
                break;
        }
    }
}
