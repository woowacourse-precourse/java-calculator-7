package calculator.myParser;

/**
 * Lexer that writes in a procedural rather than object-oriented way. It would be worse in terms of maintainability and
 * readability, but it's interesting and has enough fun.
 * <pre><code>
 *     delimiter                                  [^0-9eE-]
 *     digit                                      [0-9]
 *     %%
 *     "//"                                       { value = "  "; return MyToken.DEL_OPEN; }
 *     "\\n"                                      { value = "  "; return MyToken.DEL_CLOSE; }
 *     {delimiter}                                { value = delimiter; return MyToken.DELIMITER; }
 *     {digit}+(\.{digit}+)?([eE]-?{digit}+)?     { value = number; return MyToken.NUMBER; }
 *     .                                          { throw new IllegalArgumentException(); }
 * </code></pre>
 *
 * @see MyParser
 * @see MyToken
 */
public class MyLexer {
    public static final String ERR_MSG_WHEN_WRONG_TOKEN = "해석할 수 없는 토큰입니다.";

    private final String input;
    private int pos;
    private String value;

    /**
     * Constructor for MyLexer. After construction, call <code>forward</code> to lexically analyse the input.
     *
     * @param input input string to lexical analyze
     */
    public MyLexer(String input) {
        this.input = input;
        this.pos = 0;
        this.value = "";
    }

    /**
     * @return The last value obtained during lexical analysis
     */
    public String getValue() {
        return value;
    }

    /**
     * Go back by one token.
     * <p>
     * <b>Caution!</b> Calling this method twice in a row without calling <code>forward</code> will result in unknown
     * behaviour.
     */
    public void backward() {
        pos -= value.length();
    }

    /**
     * Step forward to the next token.
     * <p>
     * <ul>
     *     <li>If the next token is a delimiter, the value of the token is the delimiter itself.</li>
     *     <li>If the next token is a number, the value of the token is the number itself.</li>
     * </ul>
     *
     * @return <code>MyToken</code> of the next token (<code>null</code> if EOF)
     * @throws IllegalArgumentException if the input string is invalid
     */
    public MyToken forward() {
        if (pos >= input.length()) {
            return null;
        }

        char ch = input.charAt(pos);

        // test if `MyToken.DEL_OPEN`
        if (ch == '/' && pos + 1 < input.length() && input.charAt(pos + 1) == '/') {
            value = "  ";   // for `backward`, assign an arbitrary 2 length string
            pos += 2;
            return MyToken.DEL_OPEN;
        }

        // test if `MyToken.DEL_CLOSE`
        if (ch == '\\' && pos + 1 < input.length() && input.charAt(pos + 1) == 'n') {
            value = "  ";   // for `backward`, assign an arbitrary 2 length string
            pos += 2;
            return MyToken.DEL_CLOSE;
        }

        // test if `MyToken.DELIMITER`
        if (!Character.isDigit(ch) && ch != 'e' && ch != 'E' && ch != '.' && ch != '-') {
            value = String.valueOf(ch);
            pos++;
            return MyToken.DELIMITER;
        }

        // test if `MyToken.NUMBER`
        if (Character.isDigit(ch) || ch == '.') {
            value = readNumber();
            return MyToken.NUMBER;
        }

        throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_TOKEN);
    }

    // Caution!
    // The return value must be a string that `Double::parseDouble` can parse.
    private String readNumber() {
        StringBuilder sb = new StringBuilder();

        int lenDigit = readDigits(sb);
        if (pos < input.length() && input.charAt(pos) == '.') {
            sb.append(input.charAt(pos++));
            lenDigit += readDigits(sb);
        }

        boolean hasDigit = lenDigit > 0;
        if (!hasDigit) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_TOKEN);
        }

        // accept scientific notation
        if (pos < input.length() && (input.charAt(pos) == 'e' || input.charAt(pos) == 'E')) {
            sb.append(input.charAt(pos++));

            if (pos < input.length() && input.charAt(pos) == '-') {
                sb.append(input.charAt(pos++));
            }

            readDigits(sb);
        }

        return sb.toString();
    }

    private int readDigits(StringBuilder sb) {
        int posBefore = pos;
        while (pos < input.length()) {
            char ch = input.charAt(pos);
            if (!Character.isDigit(ch)) {
                break;
            }

            sb.append(ch);
            pos++;
        }
        return pos - posBefore;
    }
}
