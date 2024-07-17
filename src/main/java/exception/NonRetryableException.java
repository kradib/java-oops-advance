package exception;

public class NonRetryableException extends Exception{
    public NonRetryableException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public NonRetryableException(final String message) {
        super(message);
    }
}
