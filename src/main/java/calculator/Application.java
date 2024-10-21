package calculator;

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class Application {
    private int answer = 0;

    public static void main(String[] args) {
        System.out.println(new Application().calculator());
    }

    public String calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        if (isEmptyOrNull(input)) {
            scanner.close();
            return "결과 : 0";
        }

        if (isCustomDelimiter(input)) {
            addWithCustomDelimiter(input);
        } else {
            addWithDefaultDelimiters(input);
        }

        addWithDefaultDelimiters(input);

        scanner.close();
        return "결과 : " + answer;
    }

    private boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }

    private void addWithDefaultDelimiters(String input) {
        String[] numbers = input.split("[,:]");
        addNumbers(numbers);
    }

    private void addNumbers(String[] numbers) {
        try {
            Stream.of(numbers).forEach(this::addNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값이 포함되었습니다.");
        }
    }

    private void addNumber(String number) {
        int value = Integer.parseInt(number);
        if (value <= 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        answer += value;
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private void addWithCustomDelimiter(String input) {
        String delimiter = String.valueOf(input.charAt(2));
        String numbers = input.substring(5);
        addNumbers(numbers.split(Pattern.quote(delimiter)));
    }
}