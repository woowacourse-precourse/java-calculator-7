package calculator.service;

import java.util.Arrays;

public class Calculator {
    private String[] separateNumbers(String input) {
        if (input.startsWith("//")) {
            int customStart = input.indexOf("//");
            int customEnd = input.indexOf("\\");
            // 구분자 정의
            String separator = input.substring(customStart + 2, customEnd);

            // 숫자 부분만 추출
            input = input.substring(customEnd + 2);

            // 커스텀 구분자로 분리
            return input.split(separator);
        }
        // 기본 구분자
        return input.split("[,:]");
    }
}
