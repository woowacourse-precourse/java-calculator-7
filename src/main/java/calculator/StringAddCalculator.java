package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sumTokens(tokens);
    }

    private static String[] splitInput(String input) {
        if (input.startsWith("//")) {
            return splitWithCustomDelimiter(input);
        }
        return input.split("[,:]");
    }

    private static String[] splitWithCustomDelimiter(String input) {

        int delimiterIndex = input.indexOf("\\n");
     
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }

        String customDelimiter = input.substring(2, delimiterIndex);

        customDelimiter = customDelimiter.replace("\\", "\\\\");
        
        String numbers = input.substring(delimiterIndex + 2);

        return numbers.split(customDelimiter);
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {

            int number = parseNumber(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
        }
    }
}