package by.aston;

public class FactorialException extends RuntimeException {

    public static final String NEGATIVE_NUMBER = "The number is negative. The number must be greater than zero.";
    public static final String TOO_BIG_NUMBER = "Can't calculate factorial for this number = %d.";

    public FactorialException() {
    }

    public FactorialException(String message) {
        super(message);
    }

    public FactorialException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactorialException(Throwable cause) {
        super(cause);
    }

    public FactorialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
