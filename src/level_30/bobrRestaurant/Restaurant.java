package level_30.bobrRestaurant;

import level_30.bobrRestaurant.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Cook cook = new Cook("Cooker");
        Tablet tablet = new Tablet(5);

        tablet.addObserver(cook);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
