package calculator;

public class Calculator {

    public static int stringSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] check = checkDelimiter(input);
        String delimiters = check[0];
        String numbersSection = check[1];

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

            if (end == -1) {
                break;
            }

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
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }
}