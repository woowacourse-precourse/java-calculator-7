package calculator.model;

public class Calculator {
    private final StringSplitter stringSplitter;

    public Calculator(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    public int add(String input) {
        String[] numbers = stringSplitter.split(input);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = parseNumber(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            total += parsedNumber;
        }
        return total;
    }

    private int parseNumber(String str) {
        if (!str.matches("[0-9]+")) {  // 숫자가 아닌 문자에 대한 예외 처리
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }
}