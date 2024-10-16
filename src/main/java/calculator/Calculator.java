package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    // TODO : 메서드를 더 나눠야함. calculator 는 현재 parsing 및 덫셈 작업, validation을 하고있음
    // TODO : validation -> (IAE 터트리게), parsing 작업 후 숫자만 반환, calculaator는 반환 된 숫자를 더할 수 있도록

    public int calculator(String input) {
        if (DelimiterParser.isDefaultDelimiter(input)) {
            List<Integer> listAsInteger = DelimiterParser.getNumbersAfterParsing(input);
            Validator.validateIfInputNegative(listAsInteger);
        }
        if (!DelimiterParser.isDefaultDelimiter(input)) {
            List<Integer> listAsInteger = DelimiterParser.getNumbersAfterParsing(input);
            Validator.validateIfInputNegative(listAsInteger);
            String replaceInput = input.replace("//", "")
                    .replace("\\n", "")
                    .trim();
            String customDelimiter = replaceInput.substring(0, 1);
            return Arrays.stream(replaceInput.substring(1)
                            .split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return 0;
        /*if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return Integer.parseInt(input);
        }*/
    }
}
