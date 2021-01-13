package level_17.task_2.task_2_4;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            if (president == null) president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
