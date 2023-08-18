package pl.jw.library.app;

class LibraryApp {
    private static final String APP_NAME = "LibraryApp";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }
}
