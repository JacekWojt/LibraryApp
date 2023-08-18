package pl.jw.library.io.file;

import pl.jw.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
