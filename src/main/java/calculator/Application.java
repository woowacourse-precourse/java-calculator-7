package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class FindNum {
    public List<Integer> splitNumbers(String input, String delimiter) {
        List<Integer> result = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber.append(currentChar);
            } else if (currentChar == '-' || currentChar == '+') {
                currentNumber.append(currentChar);
            } else if (delimiter.indexOf(currentChar) >= 0) {
                if (currentNumber.length() > 0) {
                    int num = Integer.parseInt(currentNumber.toString());
                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
                    }
                    result.add(num);
                    currentNumber.setLength(0); // 숫자 초기화
                }
            }
        }

        if (currentNumber.length() > 0) {
            int num = Integer.parseInt(currentNumber.toString());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            result.add(num);
        }
        return result;
    }
}

class Calculate {
    public int result(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}

class FindCustomDel {
    public String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return Character.toString(input.charAt(2));
        }
        return ",|:";
    }

    public String extractNumbers(String input) {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf('\n') + 1);
        }
        return input;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 문자열 입력

        FindCustomDel customDel = new FindCustomDel();
        String delimiter = customDel.getDelimiter(input);
        String numbersPart = customDel.extractNumbers(input);

        FindNum numberExtractor = new FindNum();
        List<Integer> numbers = numberExtractor.splitNumbers(numbersPart, delimiter);

        Calculate calculator = new Calculate();
        int sum = calculator.result(numbers);

        System.out.println("결과 : " + sum);
    }
}
