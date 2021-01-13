package level_17.task_4_bobr.task_4_12_Transactions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        reader.close();

        FileInputStream fIStream = new FileInputStream(nameFile1);
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(fIStream));

        String s;
        while ((s = readerFile.readLine()) != null) {
            allLines.add(s);
        }
        fIStream.close();
        readerFile.close();

        fIStream = new FileInputStream(nameFile2);
        readerFile = new BufferedReader(new InputStreamReader(fIStream));

        while ((s = readerFile.readLine()) != null) {
            forRemoveLines.add(s);
        }
        fIStream.close();
        readerFile.close();

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Error!");
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

