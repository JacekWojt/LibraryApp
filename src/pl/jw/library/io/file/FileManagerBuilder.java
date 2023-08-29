package pl.jw.library.io.file;

import pl.jw.library.exception.NoSuchTypeException;
import pl.jw.library.io.ConsolePrinter;
import pl.jw.library.io.DataReader;

import java.util.Locale;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build() {
        printer.printLine("Wybierz format danych:");
        FileType fileType = getFileType();
        return switch (fileType) {
            case SERIAL -> new SerializableFileManager();
            case CSV -> new CsvFileManager();
            default -> throw new NoSuchTypeException("Nieobsługiwany typ danych");
        };
    }

    private FileType getFileType() {
        boolean typeOk = false;
        FileType result = null;
        do {
            printTypes();
            String type = reader.getString().toUpperCase(Locale.ROOT);
            try {
                result = FileType.valueOf(type);
                typeOk = true;
            } catch (IllegalArgumentException e) {
                printer.printLine("Nieobsługiwany typ danych, wybierz ponownie.");
            }
        } while (!typeOk);
        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }
}
