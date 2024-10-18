package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {

        String separator = ",|:"; // 기본 구분자: 쉼표와 콜론
        int sum = 0;

        // 커스텀 구분자
        if (input.contains("//")) {
            // 커스텀 구분자 앞부분의 숫자 부분을 먼저 계산
            String prefix = input.substring(0, input.indexOf("//")).trim();
            if (!prefix.isEmpty()) {
                sum += sumNumbers(prefix.split(separator));
            }

            // '\\n' 앞까지가 구분자 부분
            int separatorIndex = input.indexOf("\\n");
            if (separatorIndex != -1) {
                // '//' 뒤부터 '\\n' 앞까지의 문자를 구분자로 사용
                String customSeparator = input.substring(input.indexOf("//") + 2, separatorIndex);

                if (customSeparator.length() > 1) {
                    throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다.");
                }
                if (Pattern.matches("\\d", customSeparator)) {
                    throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
                }

                separator = separator + "|" + Pattern.quote(customSeparator);  // 기본 구분자에 커스텀 구분자 추가
                // 커스텀 구분자를 추출했으니 그 이후의 숫자 문자열만 남김
                input = input.substring(separatorIndex + 2);
            }
        }

        // 나머지 문자열에서 구분자 기준으로 숫자 분리 및 합산
        sum += sumNumbers(input.split(separator));

        return sum;
    }

    // 숫자 배열의 합을 계산하는 메서드
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num <= 0) {
                    throw new IllegalArgumentException("숫자는 1 이상의 양수여야 합니다");
                }
                sum += num;
            }
        }
        return sum;
    }
}
