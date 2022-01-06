package level_30.bobrRestaurant.kitchen;

import level_30.bobrRestaurant.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg.toString().concat(" was cooked by ").concat(o.toString()));
    }
}
