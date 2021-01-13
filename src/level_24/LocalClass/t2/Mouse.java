package level_24.LocalClass.t2;

/*
обратите внимание, как именно Mouse отличаетс от Cat
Этот класс - привычный дл вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}