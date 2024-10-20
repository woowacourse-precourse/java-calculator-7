package calculator;

public class Calculator {

    private static final char DEFAULT_DELIMITER1 = ',';
    private static final char DEFAULT_DELIMITER2 = ':';
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final CalculatorConsole calculatorConsole = new CalculatorConsole();

    public void run() {
        String input = calculatorConsole.inputString();
        System.out.println("결과 : " + stringSplit(input));
    }

    private int stringSplit(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            numbers = splitCustomDelimiter(input);
        } else {
            numbers = splitDefaultDelimiter(input);
        }
        return sumPositiveNumbers(numbers);
    }

    private String[] splitCustomDelimiter(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_SUFFIX, 3)) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }
        char customDelimiter = input.charAt(2);

        // 커스텀 구분자 부분 삭제
        String data = input.substring(5);
        return data.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2 + "|" + customDelimiter);
    }

    private String[] splitDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2);
    }

    private int sumPositiveNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            int extractNumber = extractPositiveNumber(number);
            result += extractNumber;
        }
        return result;
    }

    private int extractPositiveNumber(String number) {
        try {
            int positiveNumber = Integer.parseInt(number);
            // 0 또는 음수일 경우 예외처리
            if (positiveNumber <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 허용되지 않습니다.");
            }
            return positiveNumber;
            // 숫자가 아닌 경우 예외처리
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }


}
