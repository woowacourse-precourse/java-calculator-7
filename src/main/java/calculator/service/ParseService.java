package calculator.service;

import calculator.constant.Message;
import calculator.model.Expression;
import calculator.model.Operators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseService {

    static public void parseExpression(String sentence, Operators operators, Expression expression) {
        sentence = sentence.replace(" ", "").replace("\n", "");
        sentence = extractSeparator(sentence, operators);
        formulate(sentence, expression);
    }

    static private String extractSeparator(String sentence, Operators separators) {
        Matcher matcher = Pattern.compile("^//(.)\\\\n(.*)").matcher(sentence); // "//(separator)\n"...
        if (matcher.find()) {
            char separator = matcher.group(1).charAt(0);
            if (Character.isDigit(separator)) {
                throw new IllegalArgumentException(Message.SELECTOR_EXCEPTION_MESSAGE + "숫자 형태의 구분자");
            }
            separators.addOperators(separator);
            return matcher.group(2);
        }
        return sentence;
    }

    static private void formulate(String sentence, Expression expression) {
        StringBuilder operand = new StringBuilder();

        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)/* || ch == '-'*/) { // 일단 음수는 불가능
                operand.append(ch);
            } else {
                if (!operand.isEmpty()) {
                    expression.addToken(Integer.parseInt(operand.toString()));
                }
                operand.delete(0, operand.length());
                expression.addToken(ch);
            }
        }
        if (!operand.isEmpty()) {
            expression.addToken(Integer.parseInt(operand.toString()));
        }
    }
}
