package by.aston;

public class FactorialException extends IllegalArgumentException {

    public static final String messageException = "The number is negative. The number must be greater than zero";

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
/*
    public FactorialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }*/
}
