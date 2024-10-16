package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    // TODO : 메서드를 더 나눠야함. calculator 는 현재 parsing 및 덫셈 작업, validation을 하고있음
    // TODO : validation -> (IAE 터트리게), parsing 작업 후 숫자만 반환, calculaator는 반환 된 숫자를 더할 수 있도록

    public int calculator(String input) {
        if (DelimiterParser.isDefaultDelimiter(input)) {
            String splitInput = DelimiterParser.splitInputAsString(input);
            Validator.validateIfInputNotNumber(splitInput);
            List<Integer> listAsInteger = DelimiterParser.getNumbersAfterParsing(splitInput);
            Validator.validateIfInputNegative(listAsInteger);

            return listAsInteger.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
        if (!DelimiterParser.isDefaultDelimiter(input)) {
            String replaceInput = input.replace("//", "")
                    .replace("\\n", "")
                    .trim(); // ;1;2;3
            String customDelimiter = replaceInput.substring(0, 1);// 구분자 ;
            String splitString = Arrays.toString(replaceInput.substring(1).split(customDelimiter));
            String splitInput = DelimiterParser.splitInputAsString(splitString);
            Validator.validateIfInputNotNumber(splitInput);
            List<Integer> listAsInteger = DelimiterParser.getNumbersAfterParsing(splitInput);

            return listAsInteger.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
        return 0;
    }
}
