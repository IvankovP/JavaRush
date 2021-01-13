package level_19.bobr.t11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(name));
        String s;

        while ((s = reader.readLine()) != null) {
            System.out.println(new StringBuilder(s).reverse());
        }

        reader.close();
    }
}
