package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class StringCalculator {

    // 정규식으로 숫자 패턴 정의
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int add(String input) {
        // 입력이 null이거나 빈 문자열일 경우 0을 반환
        if (input == null || input.isEmpty()) {
            System.out.println("입력이 비어있습니다.");
            return 0;
        }

        System.out.println("입력 값: " + input);

        String[] numbers;
        String delimiter = DEFAULT_DELIMITERS; // 기본 구분자 설정

        // 커스텀 구분자가 있을 경우 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            System.out.println("구분자 찾기 :  "  + delimiterEndIndex);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다: 커스텀 구분자가 제대로 정의되지 않았습니다.");
            }
            System.out.println("커스텀 구분자 구분 후 : " + delimiterEndIndex);
            // 구분자 부분만 추출하여 전달 (2부터 delimiterEndIndex까지)
            String delimitersPart = input.substring(2, delimiterEndIndex);  // 수정: 구분자 부분만 추출
            delimiter = extractCustomDelimiters(delimitersPart);  // 수정: 구분자 부분만 전달
            System.out.println("커스텀 구분자: " + delimiter);

            input = input.substring(delimiterEndIndex + 2); // 구분자 이후 숫자 부분 추출
            System.out.println("숫자 부분: " + input);
        }

        // 구분자로 숫자를 분리
        numbers = splitByDelimiter(input, delimiter);

        // 분리된 숫자 출력
        System.out.println("분리된 숫자: ");
        for (String num : numbers) {
            System.out.println(num);
        }

        // 모든 숫자가 비어있다면 0 반환
        if (areAllEmpty(numbers)) {
            System.out.println("모든 숫자가 비어있습니다.");
            return 0;
        }

        // 숫자 합산 후 결과 반환
        return sum(numbers);
    }

    // 커스텀 구분자 추출
    private String extractCustomDelimiters(String delimitersPart) {
        List<String> delimiters = new ArrayList<>();

        // 구분자 문자열의 길이를 사용
        for (int i = 0; i < delimitersPart.length(); i++) {  // 수정: delimitersPart.length()를 사용
            char delimiter = delimitersPart.charAt(i);
            System.out.println("추출된 특수 문자: " + delimiter);
            delimiters.add(Pattern.quote(Character.toString(delimiter)));
        }

        return String.join("|", delimiters);
    }


    // 커스텀 구분자 또는 기본 구분자로 분리
    private String[] splitByDelimiter(String input, String delimiter) {
        String combinedDelimiters = delimiter + "|" + DEFAULT_DELIMITERS;
        System.out.println("최종 구분자: " + combinedDelimiters);
        String[] a = input.split(combinedDelimiters);
        System.out.println(Arrays.toString(a));
        return a;
    }

    // 숫자 배열에 빈 값만 있을 경우 true를 반환
    private Boolean areAllEmpty(String[] numbers) {
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // 숫자 합산
    private int sum(String[] numbers) {
        int total = 0;
        System.out.println("합산 시작...");
        for (String number : numbers) {
            // 공백이 아닌 숫자일 경우 처리
            if (!number.trim().isEmpty()) {
                int num;
                try {
                    num = Integer.parseInt(number.trim());
                    System.out.println("현재 합산 중인 숫자: " + num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자가 입력되었습니다: " + number);
                }

                // 음수일 경우 예외 발생
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                total += num; // 합산
            }
        }
        System.out.println("합산 결과: " + total);
        return total;
    }
}
