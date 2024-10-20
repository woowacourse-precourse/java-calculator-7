package calculator.myParser;

import static calculator.Message.ERR_MSG_WHEN_WRONG_SYNTAX;
import static calculator.Util.mapNumbersFromStrToDouble;

import calculator.Parser;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser that writes in a procedural rather than object-oriented way. It would be worse in terms of maintainability and
 * readability, but it's interesting and has enough fun.
 * <pre><code>
 *     %token DEL_OPEN DEL_CLOSE DELIMITER NUMBER
 *
 *     line     : del_expr num_list | num_list;
 *     del_expr : DEL_OPEN del_list DEL_CLOSE;
 *     del_list : DELIMITER del_list | DELIMITER;
 *     num_list : NUMBER DELIMITER num_list | NUMBER | ;
 * </code></pre>
 *
 * @see Parser
 * @see MyLexer
 * @see MyToken
 */
public class MyParser implements Parser {
    public static final List<Character> DEFAULT_DELIMITERS = List.of(',', ':');

    @Override
    public List<Double> parse(String input) {
        MyLexer lexer = new MyLexer(input);
        return parseLine(lexer);
    }

    private List<Double> parseLine(MyLexer lexer) {
        MyToken startToken = lexer.forward();
        lexer.backward();

        List<Character> delimiters = DEFAULT_DELIMITERS;
        if (startToken == MyToken.DEL_OPEN) {
            delimiters = parseDelExpr(lexer);
        }

        List<String> numbersStr = parseNumList(lexer, delimiters);
        List<Double> numbersDouble = mapNumbersFromStrToDouble(numbersStr);

        if (lexer.forward() != null) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
        }

        return numbersDouble;
    }

    private List<Character> parseDelExpr(MyLexer lexer) {
        List<Character> customDelimiters = new ArrayList<>();

        MyToken curr = lexer.forward();
        if (curr != MyToken.DEL_OPEN) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
        }

        while ((curr = lexer.forward()) == MyToken.DELIMITER) {
            customDelimiters.add(lexer.getValue().charAt(0));
        }

        if (curr != MyToken.DEL_CLOSE) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
        }

        return customDelimiters;
    }

    private List<String> parseNumList(MyLexer lexer, List<Character> delimiters) {
        MyToken startToken = lexer.forward();
        List<String> numbers = new ArrayList<>();

        // empty list
        if (startToken == null) {
            return numbers;
        }

        if (startToken != MyToken.NUMBER) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
        }

        // get numbers separated by delimiter
        numbers.add(lexer.getValue());
        while (lexer.forward() == MyToken.DELIMITER) {
            validateDelimiter(lexer.getValue(), delimiters);

            if (lexer.forward() != MyToken.NUMBER) {
                throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
            }
            numbers.add(lexer.getValue());
        }

        return numbers;
    }

    private void validateDelimiter(String delimiter, List<Character> delimiters) {
        if (!delimiters.contains(delimiter.charAt(0))) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_WRONG_SYNTAX);
        }
    }
}
