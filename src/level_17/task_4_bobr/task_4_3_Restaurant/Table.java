package level_17.task_4_bobr.task_4_3_Restaurant;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Order getOrder() {
        return new Order(number);
    }
}

