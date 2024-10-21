package calculator;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Calculator {
    private String userInput;
    private String delimiter; // 기본 구분자

    public Calculator(String userInput) {
        this(userInput, ",|:");
    }

    public Calculator(String userInput, String delimiter) {
        this.userInput = userInput;
        this.delimiter = delimiter;
    }

    public long calculate() {
        if (userInput == null || userInput.isEmpty()) {
            return 0;


        }

        // 1. 커스텀 구분자가 있는지 확인
        if (userInput.startsWith("//")) {
            int delimiterEndIndex = userInput.indexOf("\\n"); // \n의 위치를 알아내 구간 설정
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력: => \\n을 찾을 수 없습니다");
            }

            // 2. 커스텀 구분자 추출
            String customDelimiter = userInput.substring(2, delimiterEndIndex);

            // 3. 단일 문자만 허용

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력: => 커스텀문자가 없습니다.");
            }

            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("잘못된 입력: => 커스텀문자는 단일 문자만 입력할 수 있습니다.");
            }

            // 4. 숫자가 포함된 구분자는 허용하지 않음
            if (customDelimiter.matches("\\d")) {
                throw new IllegalArgumentException("잘못된 입력: => 구분자에 숫자는 포함될 수 없습니다.");
            }

            customDelimiter = Pattern.quote(customDelimiter); //모든 특수문자를 이스케이프
            userInput = userInput.substring(delimiterEndIndex + 2);  // 숫자 부분만 추출

            // 기본 구분자와 커스텀 구분자를 모두 포함한 정규식 생성
            delimiter = delimiter + "|" + customDelimiter;
        }
        // -1의 의미 :마지막에 구분자가 있을 경우 빈 문자열도 배열에 포함. 예=> "1,2,"
        String[] numbers = userInput.split(delimiter, -1);  // 쉼표와 콜론,(커스텀구분자)으로 분리
        long sum = 0;
        for (String number : numbers) {
            try {

                if (number.isEmpty()) {
                    throw new IllegalArgumentException("잘못된 입력: 구분자와 숫자 매치가 맞지 않습니다.");
                }

                // BigInteger를 사용해 숫자 범위 검증
                BigInteger bigValue = new BigInteger(number);

                if (bigValue.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                    throw new IllegalArgumentException("잘못된 입력: 정수 표현범위를 넘어섰습니다.");
                }

                long value = bigValue.longValue();  // long으로 변환

                if (value < 0) {
                    throw new IllegalArgumentException("잘못된 입력: 음수는 포함될 수 없습니다. " + value);
                }

                sum += value;

                if (sum < 0) {
                    throw new IllegalArgumentException("잘못된 입력: 더하는 과정에서 정수 표현범위를 넘어섰습니다. ");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력: 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        return sum;
    }
}
