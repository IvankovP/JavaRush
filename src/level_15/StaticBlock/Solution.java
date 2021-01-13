package level_15.StaticBlock;

/*
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            if (s.equals("helicopter")) result = new Helicopter();
            else if (s.equals("plane")) {
                int countPass = Integer.parseInt(reader.readLine());
                result = new Plane(countPass);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
