package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        }

        String delimiter = "[,:]";  // 기본 구분자

        // 커스텀 구분자 처리
        if (str.startsWith("//")) {
            int delimiterIndex1 = str.indexOf('\\');
            int delimiterIndex2 = str.indexOf('n');
            if (delimiterIndex1 == -1 || delimiterIndex2 == -1) {
                throw new IllegalArgumentException("구분자가 잘못 입력되었습니다.");
            }
            try {
                if (str.charAt(3) == '\\' && str.charAt(4) == 'n') {
                    String delimiterCustom = str.substring(2, delimiterIndex1);
                    if (delimiterCustom.length() > 1) {
                        throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
                    }
                    if (Character.isDigit(delimiterCustom.charAt(0))) {
                        throw new IllegalArgumentException("구분자로 숫자가 입력되었습니다.");
                    }
                    delimiter = Pattern.quote(delimiterCustom);
                }
                str = str.substring(delimiterIndex2 + 1);
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 구분자가 입력되었습니다.");
            }
        }

        String[] strArr = str.split(delimiter);
        int sum = 0;

        // 숫자 합 계산 및 음수 처리
        for (String token : strArr) {
            try {
                int number = Integer.parseInt(token);
                if (number <= 0) {
                    throw new IllegalArgumentException("잘못된 숫자값이 입력되었습니다: " + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }

        System.out.println("결과 : " + sum);
    }
}
