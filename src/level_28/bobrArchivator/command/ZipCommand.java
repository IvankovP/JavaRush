package level_28.bobrArchivator.command;

import level_28.bobrArchivator.ConsoleHelper;
import level_28.bobrArchivator.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива");
        String zipFile = ConsoleHelper.readString();
        Path zipFilePath = Paths.get(zipFile);
        return new ZipFileManager(zipFilePath);
    }
}
