package level_30.bobrRestaurant.kitchen;

import level_30.bobrRestaurant.ConsoleHelper;
import level_30.bobrRestaurant.Tablet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        return dishes.size() == 0 ? "" : String.format("Your order: %s of %s, cooking time %dmin", Arrays.toString(dishes.toArray()), tablet.toString(), getTotalCookingTime());
    }

    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
