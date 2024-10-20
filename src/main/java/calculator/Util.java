package calculator;

import static calculator.Message.ERR_MSG_WHEN_FAIL_TO_PARSE_NUMBER;

import java.util.List;

public class Util {
    static public List<Double> mapNumbersFromStrToDouble(List<String> numbersStr) {
        try {
            return numbersStr.stream()
                    .map(Double::parseDouble)
                    .toList();
        } catch (NumberFormatException _ignored) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_FAIL_TO_PARSE_NUMBER);
        }
    }
}
