package level_14.Valuti;

public class Hrivna extends Money {
    @Override
    public String getCurrencyName() {
        return "UAH";
    }

    public Hrivna(double amount) {
        super(amount);
    }
}
