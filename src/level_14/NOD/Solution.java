package level_14.NOD;

/*
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int i1 = Integer.parseInt(reader.readLine());
            int i2 = Integer.parseInt(reader.readLine());
            if (i1 > 0 && i2 > 0) {
                int nod = 0;
                int min = Math.min(i1, i2);
                for (int i = 1; i <= min; i++)
                    if (i1 % i == 0 && i2 % i == 0) nod = i;
                System.out.println(nod);
            }
            else throw new Exception();
    }
}
