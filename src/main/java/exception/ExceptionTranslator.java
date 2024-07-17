package exception;

import java.util.Map;

public class ExceptionTranslator {

    private static final Map<Class<? extends Exception>, Class<? extends Exception>> translatorMap = Map.of(
            UserNotFoundException.class, NonRetryableException.class,
            RandomException.class, RetryableException.class,
            UserCreationException.class, RetryableException.class
    );

    public static  <T extends Exception> Exception translate(T ex) {
        Class<? extends Exception> translatedClass = translatorMap.getOrDefault(ex.getClass(), NonRetryableException.class);
        try {
            return translatedClass.getConstructor(String.class).newInstance(ex.getMessage());
        } catch (Exception e) {
            // Handle the reflection exception
            e.printStackTrace();
            return new NonRetryableException("Failed to translate exception");
        }
    }
}
