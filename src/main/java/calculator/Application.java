package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String COMMA_AND_SEMICOLON = COMMA + "|" + SEMICOLON;
    private static final String EMPTY = "";
    private static final String REX_ONLY_NUMBER = "\\d+";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\\\n";
    private static final String REX_CUSTOM_DELIMITER_FORMAT = ".*//(.+)\\\\n.*";

    public static void main(String[] args) {
        String input = Console.readLine();
        BigInteger result = add(input);
        System.out.println("결과 : " + result);
    }

    private static BigInteger add(String input) {
        boolean isNotContainingDelimiter = !input.contains(COMMA) && !input.contains(SEMICOLON);

        if (input.isEmpty()) {
            return BigInteger.valueOf(0);
        }

        if (isNotContainingDelimiter || input.matches(REX_CUSTOM_DELIMITER_FORMAT)) {
            if (input.matches(REX_CUSTOM_DELIMITER_FORMAT)) {
                List<String> customDelimiterInputs = Arrays.stream(input.split(CUSTOM_DELIMITER_END))
                        .filter(letter -> !letter.isBlank())
                        .toList();

                String expression = customDelimiterInputs.getLast();

                if (expression.contains(CUSTOM_DELIMITER_START)) {
                    throw new IllegalArgumentException("커스텀 구분자 이후로 수식이 없습니다");
                }

                if (customDelimiterInputs.size() > 2) {
                    throw new IllegalArgumentException("커스텀 구분자가 2개이상 있습니다");
                }

                String firstToTwoLetter = customDelimiterInputs.getFirst().substring(0, 2);
                if (!firstToTwoLetter.equals(CUSTOM_DELIMITER_START)) {
                    throw new IllegalArgumentException("커스텀 구분자의 형식인 //로 시작하지 않습니다");
                }

                String customDelimiter = customDelimiterInputs.getFirst().substring(2);
                try {
                    new BigInteger(customDelimiter);
                } catch (NumberFormatException e) {
                    return BigInteger.valueOf(0);
                }
                throw new IllegalArgumentException("구분자에 숫자가 들어있습니다");
            }

            throw new IllegalArgumentException("구분자가 없습니다");
        }

        String[] delimiters = {COMMA, SEMICOLON, COMMA_AND_SEMICOLON};
        for (String delimiter : delimiters) {
            validateOnlyDelimiter(input, delimiter);
        }

        List<String> stringInputs = Arrays.stream(input.split(COMMA_AND_SEMICOLON))
                .filter(letter -> !letter.equals(EMPTY))
                .map(String::trim)
                .toList();

        List<BigInteger> bigIntegerParsedInputs;
        try {
            bigIntegerParsedInputs = stringInputs.stream()
                    .map(BigInteger::new)
                    .toList();

        } catch (NumberFormatException e) {
            for (String stringInput : stringInputs) {
                boolean isNumeric = stringInput.matches(REX_ONLY_NUMBER);
                if (!isNumeric) {
                    throw new IllegalArgumentException("피연산자에 숫자가 아닌 다른 문자가 있습니다");
                }
            }

            throw new IllegalArgumentException("파싱시 알 수 없는 에러가 있습니다");
        }

        for (BigInteger inputNumber : bigIntegerParsedInputs) {
            if (inputNumber.compareTo(BigInteger.ZERO) == 0) {
                throw new IllegalArgumentException("0을 포함합니다");
            }

            if (inputNumber.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("음수를 포함합니다");
            }
        }

        return bigIntegerParsedInputs.stream().reduce(BigInteger.valueOf(0), BigInteger::add);
    }

    private static void validateOnlyDelimiter(String input, String delimiter) {
        List<String> inputs = Arrays.stream(input.split(delimiter)).toList();
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException(delimiter + " 밖에 없습니다");
        }
    }

}
