package exception;


//checked Exception
public class UserNotFoundException extends Exception {

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public UserNotFoundException(final Throwable throwable) {
        super(throwable);
    }


}
