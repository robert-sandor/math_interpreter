package ro.sandorrobertk94.math_interpreter;

/**
 * Created by robert on 10/6/15.
 */
public class Lexer {
    private String input;
    private int pos;
    private String current_char;

    public Lexer(String input) {
        this.input = input;
        this.pos = 0;
        this.current_char = String.valueOf(input.charAt(this.pos));
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    private void error() throws Exception {
        throw new Exception(
                "Invalid character found at ".concat(Integer.toString(this.pos)).concat(" = " + this.current_char)
        );
    }

    private void advance() {
        this.pos += 1;
        if (this.pos >= this.input.length()) {
            this.current_char = null;
        } else {
            this.current_char = String.valueOf(input.charAt(this.pos));
        }
    }

    private void skip_whitespace() {
        while (this.current_char != null && this.current_char.contentEquals(" ")) {
            this.advance();
        }
    }

    public Token getNextToken() throws Exception {
        while (this.current_char != null) {

            if (this.current_char.contentEquals(" ")) {
                this.skip_whitespace();
            }

            if (this.current_char.charAt(0) >= '0' &&
                this.current_char.charAt(0) <= '9') {
                return new Token(Token.INTEGER, this.integer());
            }

            if (this.current_char.contentEquals("+")) {
                this.advance();
                return new Token(Token.PLUS, "+");
            }

            if (this.current_char.contentEquals("-")) {
                this.advance();
                return new Token(Token.MINUS, "-");
            }

            this.error();
        }

        return new Token(Token.EOF, null);
    }

    private String integer() {
        String result = "";
        while ( this.current_char != null &&
                this.current_char.charAt(0) >= '0' &&
                this.current_char.charAt(0) <= '9') {
            result += this.current_char;
            this.advance();
        }
        return result;
    }
}
