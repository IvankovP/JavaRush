package level_28.bobrArchivator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name archive:");
        String pathEndFile = bufferedReader.readLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathEndFile));

        System.out.println("Enter file name for archive:");
        String pathFileForArchive = bufferedReader.readLine();
        try {
            zipFileManager.createZip(Paths.get(pathFileForArchive));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
