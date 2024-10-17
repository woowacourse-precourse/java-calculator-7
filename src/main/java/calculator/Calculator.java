package calculator;

import java.util.List;

public class Calculator {


    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        DelimiterParser delimiterParser;
        // TODO : 기본구분자 일 경우엔 , | : 이걸로 나눠서 추출함
        if (DelimiterParser.isDefaultDelimiter(input)) {
            delimiterParser = new DelimiterParser(":");

            String result = delimiterParser.replace(input);
            List<Integer> inputNums = delimiterParser.parseToIntList(result);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
        // TODO : 커스텀 구분자일 경우 인덱스로 추출이 아니고 while문으로 // ~ \n 사이까지의 문자열을 커스텀 구분자로 받을 수 있도록
        String delimiter1 = input.substring(0, 2);
        String delimiter2 = input.substring(3, 5);
        delimiterParser = new DelimiterParser(delimiter1, delimiter2);

        String replaceInput = delimiterParser.replace(input);
        String customDelimiter = replaceInput.substring(0, 1);
        String numberPart = replaceInput.substring(1);
        String[] split = numberPart.split(customDelimiter);

        String splitString = String.join(",", split);

        List<Integer> inputNums = delimiterParser.parseToIntList(splitString);

        return inputNums.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
