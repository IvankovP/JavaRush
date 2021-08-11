package level_30.autoboxingCharacter.t4;

import java.util.Random;

/*
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        int delta = Math.abs(a - b);
        for (int i = 0; i <= delta; i++) {
            stringBuilder.append((a < b ? a++ : a--) + " ");
        }

        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(10);
        numberB = random.nextInt(10);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}





























