package calculator;

public class StringCalculator {
    public int calculate(String input) {

        //커스텀 구분자 추출
        Character customDelimiter = extractCustomDelimiter(input);

        //계산 문자열 구분
        String calculateStr = input;
        if (customDelimiter != null) {
            calculateStr = input.substring(input.lastIndexOf("\\n") + 2);
        }

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

            if (num < 0) {
                throw new IllegalArgumentException("양수만 입력");
            }

            ret += num;
        }

        return ret; //TODO
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

    private Character extractCustomDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = input.substring(2, input.lastIndexOf("\\n"));
            validateCustomDelimiterLength(customDelimiterStr);

            return customDelimiterStr.charAt(0);
        }

        return null;
    }

    private void validateCustomDelimiterLength(String customDelimiterStr) {
        if (customDelimiterStr.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
            throw new IllegalArgumentException();
        }
    }
}
