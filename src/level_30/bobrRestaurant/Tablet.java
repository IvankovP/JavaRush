package level_30.bobrRestaurant;

import level_30.bobrRestaurant.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());

            setChanged();
            notifyObservers(order);

            return order;

        } catch (IOException e) {
          logger.log(Level.SEVERE, "Console is unavailable");
          return null;
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
