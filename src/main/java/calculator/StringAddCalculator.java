package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
        // 문자열 덧셈 계산기 메인 메소드
        public static int add(String input) {
            // 빈 문자열 처리
            if (input == null || input.isEmpty()) {
                return 0;
            }
    
            // 커스텀 구분자가 있는지 확인
            if (input.startsWith("//")) {
                return addWithCustomDelimiter(input);
            }
    
            // 쉼표 또는 콜론을 구분자로 처리
            return addWithDefaultDelimiters(input);
        }

    // 기본 구분자(쉼표, 콜론)를 이용한 덧셈 처리
    private static int addWithDefaultDelimiters(String input) {
        String[] numbers = input.split("[,|:]"); // 쉼표 또는 콜론을 구분자로 분리
        return sum(numbers);
    }

    // 커스텀 구분자를 사용한 덧셈 처리
    private static int addWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }

        String customDelimiter = matcher.group(1); // 커스텀 구분자 추출
        String numbersPart = matcher.group(2); // 숫자 부분 추출

        String[] numbers = numbersPart.split(Pattern.quote(customDelimiter)); // 커스텀 구분자로 숫자를 분리
        return sum(numbers);
    }
    // 문자열 배열의 숫자들을 합산하는 메소드
    private static int sum(String[] numbers) {
        int total = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = toInt(number);
            if (num < 0) {
                negativeNumbers.add(num);
            }
            total += num;
        }
        if (!negativeNumbers.isEmpty()) {
            //음수가 여러개 일때 List형태로 받고 데이터 변환 후 출력
            String negatives = negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negatives);
        }
        return total;
    }
    // 문자열을 정수로 변환
    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

}

