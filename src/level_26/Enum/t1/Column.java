package level_26.Enum.t1;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый пордок отображени колонок, который хранитс в массиве realOrder.
     * realOrder[индекс в энуме] = пордок отображени; -1, если колонка не отображаетс.
     *
     * @param newOrder нова последовательность колонок, в которой они будут отображатьс в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычислет и возвращает список отображаемых колонок в сконфигурированом пордке (см. метод configureColumns)
     * Используетс поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        int[] realOrderCopy = realOrder.clone();
        Arrays.sort(realOrderCopy);

        int maxOrder = realOrderCopy[realOrderCopy.length - 1];
        realOrderCopy = null;

        if (maxOrder < 0) return result;

        int count = 0;

        while (count <= maxOrder) {
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == count) {
                    for (Column column : Column.values()) {
                        if (column.ordinal() == i) {
                            result.add(column);
                            count++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public boolean isShown() {
        if (realOrder[this.ordinal()] != -1) return true;
        return false;
    }

    public void hide() {
        int currentColumnIndex = realOrder[this.ordinal()];

        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i] > currentColumnIndex) --realOrder[i];
        }
        realOrder[this.ordinal()] = -1;
    }
}

