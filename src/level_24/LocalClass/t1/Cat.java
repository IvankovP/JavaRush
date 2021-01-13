package level_24.LocalClass.t1;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптировани к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "им_кота говорит му!". Пример дл i=3, "Васька говорит му!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит му!
     * Кошка говорит му!
     * Мышь пищит.
     * Томас говорит му!
     * <p/>
     *
     * @param i количество букв '' в слове му
     * @return экземплр класса CatPet
     */
    public Sayable toSayable(final int i) {
        class CatPet implements Sayable {
            @Override
            public String say() {
                if (i < 1) return name + " спит.";
                else {
                    StringBuilder builder = new StringBuilder(name + " говорит м");
                    for (int j = 0; j < i; j++) {
                        builder.append('я');
                    }
                    builder.append("у!");
                    return builder.toString();
                }
            }
        }
        return new CatPet();
    }
}