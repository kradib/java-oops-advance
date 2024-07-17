package exception;

//unchecked Exception
public class UserCreationException extends RuntimeException {
    public UserCreationException(final String message) {
        super(message);
    }

    public UserCreationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public UserCreationException(final Throwable throwable) {
        super(throwable);
    }
}
