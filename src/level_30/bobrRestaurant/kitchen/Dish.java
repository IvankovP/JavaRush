package level_30.bobrRestaurant.kitchen;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Dish {
    FISH, STEAK, SOUP, JUICE, WATER;

    public static String allDishesToString() {
        return Arrays.stream(values()).map(Dish::name).collect(Collectors.joining(", "));
    }
}
