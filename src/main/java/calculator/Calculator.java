package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static String get_input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();
        return input;
    }

    public static List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<Integer>();
        if (input == null || input.isEmpty()) {
            return numbers;
        }

        String delimiter = ",|:";  // 기본 구분자: 쉼표와 콜론

        // 커스텀 구분자를 사용하는지 확인
        int delimiterStartIndex = 2;
        int delimiterEndIndex = input.indexOf("\\n");

        while (input.startsWith("//")) {
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter += "|" + input.substring(delimiterStartIndex, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 2);
            delimiterEndIndex = input.indexOf("\\n");
        }

        String[] snumbers = input.split(delimiter);  // 지정된 구분자로 문자열 분리

        for (String number : snumbers) {
            if (!number.isEmpty()) {
                try {
                    int num = Integer.parseInt(number);  // 숫자로 변환
                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                    numbers.add(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
                }
            }
        }
        return numbers;
    }

    public static int add(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
