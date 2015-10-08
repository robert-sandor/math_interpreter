package ro.sandorrobertk94.math_interpreter;

/**
 * Created by robert on 10/6/15.
 */
public class Token {
    // constants for token type
    public static final String INTEGER = "INTEGER";
    public static final String PLUS = "PLUS";
    public static final String MINUS = "MINUS";
    public static final String EOF = "EOF";

    private String type;
    private String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
