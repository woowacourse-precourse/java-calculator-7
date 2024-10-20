package calculator.service;

import calculator.util.CustomDelimiterHandler;
import calculator.util.DefaultDelimiterHandler;
import calculator.util.SumHandler;
import java.util.regex.Matcher;

public class StringSumCalculator {
    public int calculateSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0; // 입력이 없을 경우 0 반환
        }

        String delimiter = DefaultDelimiterHandler.getDefaultDelimiter(); // 기본 구분자 설정
        Matcher matcher = CustomDelimiterHandler.getCustomDelimiterMatcher(str); // 커스텀 구분자 매칭

        if (matcher.find()) {
            delimiter = CustomDelimiterHandler.getCustomDelimiter(matcher); // 커스텀 구분자 추출
            str = CustomDelimiterHandler.getNumbersWithCustomDelimiter(matcher); // 숫자 부분 추출
        }

        return SumHandler.sumNumbers(str, delimiter); // 숫자의 합 계산
    }
}
