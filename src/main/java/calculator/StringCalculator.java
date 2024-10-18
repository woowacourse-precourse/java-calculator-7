package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 입력받은 문자열을 더하는 메서드
    public int add(String input) {

        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null이면 0 반환
        }

        // 쉼표 또는 콜론을 구분자로 설정
        String delimiter = ",|:";
        String numbers = input;    // 숫자 부분

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            // 패턴을 이용해 커스텀 구분자와 숫자 부분을 추출
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));  // 커스텀 구분자 설정
                numbers = matcher.group(2);  // 커스텀 구분자를 제외한 나머지 문자열
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }


        // 입력된 값 출력 (디버깅용)
        System.out.println("입력된 값: " + input);

        // 구분자를 기준으로 숫자 분리
        String[] tokens = input.split(delimiter);
        int sum = 0;
        List<String> invalidTokens = new ArrayList<>(); // 잘못된 값들을 저장할 리스트

        // 각 토큰을 정수로 변환하여 합산
        System.out.println("토큰: ");
        for (String token : tokens) {
            System.out.println("'" + token + "'");
            if (token.isEmpty()) {
                continue;  // 빈 문자열인 경우 무시
            }

            try {
                int number = parsePositiveInt(token);
                sum += number;
            } catch (IllegalArgumentException e) {
                // 잘못된 값이 있으면 invalidTokens 리스트에 추가
                invalidTokens.add(token);
            }
        }

        // 잘못된 값이 있으면 한꺼번에 예외 발생
        if (!invalidTokens.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력값: " + String.join(", ", invalidTokens));
        }

        return sum;
    }

    // 양수 정수로 변환하는 메서드 (잘못된 값이 있으면 예외 발생)
    private int parsePositiveInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + value);
        }
    }
}
