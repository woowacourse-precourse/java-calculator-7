package calculator;

import calculator.CalculationManager.Calculator;

public class StringAddCalculator implements Calculator {
    @Override
    public int calculate(String input) {
        // 아무것도 입력되지 않은 경우 0 반환
        if (input.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자가 있는지 확인하고 처리
        if (input.contains("//")) {
            return sumWithCustomSeparator(input);
        }

        // 기본 구분자로 계산
        return sumWithBasicSeparator(input);

    }

    // 커스텀 구분자로 문자열 분리 후 sum
    private static int sumWithCustomSeparator(String input) {
        // "//" 와 "\n" 사이에 있는 커스텀 문자 추출
        char custom_ch = input.charAt(2);

        // 커스텀 문자가 메타 문자인지 확인
        String escapedCustomCh = StringUtil.escapeMetaCharacters(String.valueOf(custom_ch));

        // //(커스텀문자)\n 이후를 input으로 다시 설정
        input = input.substring(5);

        // 커스텀 구분자로 문자열 분리
        String[] splitString = input.split(escapedCustomCh);

        return sum(splitString);
    }

    // 기본 구분자로 문자열 분리 후 sum
    private int sumWithBasicSeparator(String input) {
        String[] splitString = input.split(",|:");
        return sum(splitString);
    }

    // 숫자 합산 method
    private static int sum(String[] splitString) {
        int sum = 0;
        for (String s : splitString) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
