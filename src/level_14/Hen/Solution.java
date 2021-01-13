package level_14.Hen;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.RUSSIA);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country.equals("Ukraine")) return new UkrainianHen();
            else if (country.equals("Russia")) return new RussianHen();
            else if (country.equals("Moldova")) return new MoldovanHen();
            else if (country.equals("Belarus")) return new BelarusianHen();

            return hen;
        }
    }
}