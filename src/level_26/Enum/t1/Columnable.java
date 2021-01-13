package level_26.Enum.t1;

public interface Columnable {

    /**
     * @return полное им колонки
     */
    String getColumnName();

    /**
     * Возвращает true, если колонка видима, иначе false
     */
    boolean isShown();

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    void hide();

    /**
     * Возвращает пордок константы в энуме.
     *
     * @return пордок константы в энуме
     */
    int ordinal();
}

