package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        String input = null;
        String delimiter = ",|:";
        int sum = 0;
        try {
            input = Console.readLine();  // 사용자로부터 입력 받음
        } catch (NoSuchElementException e) {
            input = "";  // 입력이 없으면 빈 문자열로 처리
        }

        // 빈 문자열을 처리하는 부분
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");  // 빈 문자열이 입력되면 0 출력
            return;
        }
        boolean isCustomDelimiter = false;
        if (input.startsWith("//")) {
            isCustomDelimiter = true;
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                delimiter = input.substring(2, delimiterEnd);
                input = input.substring(delimiterEnd + 2);
            }
        }
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        if (isCustomDelimiter && delimiter.length() > 1) {//커스텀구분자가 문자가아닌 문자열일경우
            throw new IllegalArgumentException("커스텀 구분자가 문자가 아닙니다.");
        }
        String[] numbers = input.split(delimiter);

        if (isCustomDelimiter && !input.contains(delimiter)) {//구분자가 다를때
            throw new IllegalArgumentException("커스텀 구분자와 입력된 구분자가 다릅니다.");
        } else if (!isCustomDelimiter && !input.contains(",") && !input.contains(":")) {//구분자가 다를때
            throw new IllegalArgumentException("구분자와 입력된 구분자가 다릅니다.");
        }

        for (String number : numbers) {

            // 숫자로 변환할 수 없는 경우 처리
            try {
                int num = Integer.parseInt(number);

                // 음수 처리
                if (num < 0) {
                    throw new IllegalArgumentException("0 또는 음수 값은 허용되지 않습니다: " + num);
                }

                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 입력: " + number);
            }
        }

        System.out.println("결과 : " + sum);
    }
}
