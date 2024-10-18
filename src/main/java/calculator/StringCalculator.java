package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 입력받은 문자열을 더하는 메서드
    public int add(String input) {

        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null이면 0 반환
        }

        // 입력 값에 \\n 이라는 문자열이 있을 경우 \n 이라는 개행 문자로 변환
        input = input.replace("\\n", "\n");


        String delimiter = ",|:";  // 기본 구분자 (쉼표, 콜론)
        String numbers = input;

        // 콘솔에 입력값 출력
        System.out.println("입력된 값: " + input);


        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            // 정규식을 사용해 커스텀 구분자와 숫자 부분을 추출
            Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input); // \\n을 사용해 개행 문자를 처리
            if (matcher.find()) {
                // 커스텀 구분자를 추출
                String customDelimiter = matcher.group(1);
                System.out.println("커스텀 구분자로 인식된 값: '" + customDelimiter + "'");

                // 개행 문자 뒤의 숫자 부분을 추출
                numbers = matcher.group(2);
                System.out.println("숫자 부분: '" + numbers + "'");

                // 커스텀 구분자를 사용하도록 설정
                delimiter = Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }

        // 구분자를 기준으로 숫자 분리
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        // 각 토큰을 정수로 변환하여 합산
        System.out.println("토큰: ");
        for (String token : tokens) {
            System.out.println("'" + token + "'");
            if (token.isEmpty()) {
                continue;  // 빈 문자열인 경우 무시
            }

            // 숫자로 변환하여 합산
            int number = parsePositiveInt(token);
            sum += number;
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