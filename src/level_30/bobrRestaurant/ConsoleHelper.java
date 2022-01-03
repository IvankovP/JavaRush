package level_30.bobrRestaurant;

import level_30.bobrRestaurant.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
       return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String dishName;
        List<Dish> dishes = new ArrayList<>();

        writeMessage("Available dishes: ".concat(Dish.allDishesToString()));
        writeMessage("Please, enter the dish name");

        while (!(dishName = readString()).equals("exit")) {
            try {
                dishes.add(Dish.valueOf(dishName.trim().toUpperCase()));
            } catch (IllegalArgumentException e) {
                writeMessage("This dish is not exist in menu");
            }
        }

        return dishes;
    }
}
