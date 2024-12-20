package by.aston;

public class FactorialException extends IllegalArgumentException {

    public static final String messageException = "";
    public FactorialException() {
    }

    public FactorialException(String s) {
        super(s);
    }

    public FactorialException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactorialException(Throwable cause) {
        super(cause);
    }
}
