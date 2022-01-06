package level_30.bobrRestaurant;

import level_30.bobrRestaurant.kitchen.Cook;
import level_30.bobrRestaurant.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Cook cook = new Cook("Cooker");
        Tablet tablet = new Tablet(5);

        tablet.addObserver(cook);
        cook.addObserver(new Waiter());

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
