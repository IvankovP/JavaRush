package level_21.Bilaabo.t3;

/*
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static boolean calculate2(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {
        System.out.println(Solution.calculate(true, false, false, true));
        System.out.println(Solution.calculate2(true, false, false, true));
    }
}