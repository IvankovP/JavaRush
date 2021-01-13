package level_18.bobr_6_TwoInOne;

/*
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        reader.close();

        FileInputStream fI = new FileInputStream(name2);
        FileOutputStream fO = new FileOutputStream(name, true);

        byte[] fileTwo = new byte[fI.available()];
        fI.read(fileTwo);
        fO.write(fileTwo);
        fI.close();

        fI = new FileInputStream(name3);
        byte[] fileTree = new byte[fI.available()];
        fI.read(fileTree);
        fO.write(fileTree);
        fI.close();
        fO.close();
    }
}
