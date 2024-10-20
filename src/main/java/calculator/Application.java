package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String input) {
        String delimiter = ",|:";
        String[] numbers;
        int sum = 0;
        if (input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        } else if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 지정할 수 없습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            delimiter = customDelimiter + "|" + delimiter;
            input = input.substring(newlineIndex + 2);
        }
        numbers = input.split(delimiter);
        for(String number : numbers) {
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(
                    "숫자 형식이 아닙니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }
}

