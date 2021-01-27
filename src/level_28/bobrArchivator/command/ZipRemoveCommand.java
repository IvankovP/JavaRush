package level_28.bobrArchivator.command;

import level_28.bobrArchivator.ConsoleHelper;
import level_28.bobrArchivator.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите имя файла, который нужно удалить");
        Path fileForDelete = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(fileForDelete);
    }
}
