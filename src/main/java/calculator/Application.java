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
                sum += Integer.parseInt(number.trim());  // 숫자 변환 후 덧셈
            }
        }
        return sum;
    }
}
