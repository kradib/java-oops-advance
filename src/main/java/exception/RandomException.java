package exception;

import java.util.concurrent.Executors;

public class RandomException extends Exception {

    public RandomException(final String message) {
        super(message);
    }
}
