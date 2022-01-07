package level_30.bobrRestaurant.kitchen;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Dish {
    FISH(25), STEAK(30), SOUP(15), JUICE(5), WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        return Arrays.stream(values()).map(Dish::name).collect(Collectors.joining(", "));
    }
}
