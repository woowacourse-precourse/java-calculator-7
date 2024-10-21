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
        // Scanner로 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine(); // 사용자 입력 받기

        // 2️⃣ 빈 문자열 또는 null 입력 시 0 반환
        if (isEmptyOrNull(input)) {
            scanner.close();
            return "결과 : 0";
        }

        // 3️⃣ 쉼표(,) 또는 콜론(:) 구분자 처리
        if (!isCustomDelimiter(input)) {
            addWithDefaultDelimiters(input); // 쉼표, 콜론 구분자로 숫자 처리
        }
        // 4️⃣ 커스텀 구분자 지원
        else {
            addWithCustomDelimiter(input); // 커스텀 구분자 처리
        }
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
        try {
            int value = Integer.parseInt(number); // 문자열을 int로 변환
            // int 범위를 넘어가거나 음수일 경우 예외 처리
            if (value <= 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            answer += value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나 범위를 초과하였습니다.");
        }
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