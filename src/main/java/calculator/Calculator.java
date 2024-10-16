package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    // TODO : 메서드를 더 나눠야함. calculator 는 현재 parsing 및 덫셈 작업, validation을 하고있음
    // TODO : validation -> (IAE 터트리게), parsing 작업 후 숫자만 반환, calculaator는 반환 된 숫자를 더할 수 있도록

    public int calculator(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (DelimiterParser.isDefaultDelimiter(input)) {
            List<Integer> inputNums = DelimiterParser.splitInputAsString(input);
            Validator.validateIfInputNegative(inputNums);
            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }

        /*if (!DelimiterParser.isDefaultDelimiter(input)) {
            String replaceInput = input.replace("//", "")
                    .replace("\\n", "")
                    .trim(); // ;1;2;3
            String customDelimiter = replaceInput.substring(0, 1);// 구분자 ;
            String[] split = replaceInput.substring(1).split(customDelimiter);
            String splitString = String.join("", split);
            String splitInput = DelimiterParser.splitInputAsString(splitString);
            Validator.validate(splitInput);
            List<Integer> listAsInteger = DelimiterParser.getNumbersAfterParsing(splitInput);

            return listAsInteger.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }*/
        return 0;
    }
}
