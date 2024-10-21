package calculator;

public class Validation {
    // Todo: 유효한 문자열인지 확인
    public static void validate(String input) {
        if (input == null) {
            return;
        }

        if (input.startsWith("//")) {
            int delimiter = input.indexOf("\\n");
            if (delimiter == -1 || input.substring(2, delimiter + 2).isEmpty()) {
                throw new IllegalArgumentException("잘못된 값입니다.");
            }
        }
        if (!input.matches("[0-9,:]*") && !input.startsWith("//")) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    public static void CheckNegativeNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용하지 않습니다.");
                }
            }
        }
    }

}
