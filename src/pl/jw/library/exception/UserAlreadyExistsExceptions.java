package pl.jw.library.exception;

public class UserAlreadyExistsExceptions extends RuntimeException {
    public UserAlreadyExistsExceptions(String message) {
        super(message);
    }
}
