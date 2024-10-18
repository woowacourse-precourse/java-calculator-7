package calculator;

public class StringCalculator {

    private InputParser inputParser;

    public int calculate(String input) {

        //커스텀 구분자 추출
        Character customDelimiter = inputParser.extractCustomDelimiter(input);
        String calculateStr = inputParser.extractCalculationString(input, customDelimiter);

        //계산 문자열을 구분자로 분리
        String splitRegex = ":|,";
        if (customDelimiter != null) {
            splitRegex = splitRegex + "|" + customDelimiter;
        }

        String[] parsedCalculateStr = calculateStr.split(splitRegex);

        //정수로 변환 및 계산
        int ret = 0;

        for (String str : parsedCalculateStr) {
            int num = stringToInteger(str);
            validateNumPositive(num);
            ret += num;
        }

        return ret; //TODO
    }

    private void validateNumPositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("양수만 입력");
        }
    }

    private int stringToInteger(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자와 양수 이외 다른 문자는 입력x");
        }
    }
}
