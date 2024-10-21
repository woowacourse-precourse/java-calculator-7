package calculator.util;

import static calculator.model.enums.ParsingPattern.NUMBER_SPLIT_LIMIT;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.model.Numbers;
import calculator.model.NumbersToken;
import java.util.Arrays;

public class Converter {
    public static Numbers convertToNumbersFromNumbersToken(Delimiter delimiter, NumbersToken numbersToken) {
        String token = numbersToken.getToken();

        String[] extractNumbers = token.split(delimiter.getDelimiter(), NUMBER_SPLIT_LIMIT.getNumber());
        ;

        Numbers numbers = new Numbers();

        Arrays.stream(extractNumbers).map(Number::new).forEach(numbers::add);

        return numbers;
    }

    public static int convertToInteger(String number) {
        return Integer.parseInt(number);
    }
}
