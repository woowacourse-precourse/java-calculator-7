package calculator;

public class Calculator {

    public static int stringSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] check = checkDelimiter(input);
        String delimiters = check[0];
        String numbersSection = check[1];

        InputValidator.validate(delimiters, numbersSection);

        return extractAndSum(numbersSection, delimiters);
    }

    private static String[] checkDelimiter(String input) {
        StringBuilder delimiters = new StringBuilder();

        // 기본 구분자
        delimiters.append(",").append(":");

        // 커스텀 구분자
        while (input.startsWith("//")) {

            int start = 2;
            int end = input.indexOf("\\n", start);

            InputValidator.validateCustomDelimiter(input, start, end);

            String customDelimiter = input.substring(start, end);
            delimiters.append(customDelimiter);
            input = input.substring(end + 2);
        }
        return new String[] { delimiters.toString(), input };
    }

    private static int extractAndSum(String numbersSection, String delimiters) {

        String regex = "[" + delimiters + "]";
        String[] numbers = numbersSection.split(regex);
        int sum = 0;

        for (String num : numbers) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);

                if (number < 0) {
                    throw new IllegalArgumentException("유효하지 않은 입력값입니다. : " + num);
                }
                sum += number;
            }
        }
        return sum;
    }
}