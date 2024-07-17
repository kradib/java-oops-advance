package exception;

public class RetryableException extends  Exception {
    public RetryableException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public RetryableException(final String message) {
        super(message);
    }
}
