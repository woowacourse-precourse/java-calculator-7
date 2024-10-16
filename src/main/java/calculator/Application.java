package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

        if (!isCustom(input)) {
            DelimiterResult regex = new DelimiterResult(defaultDelimiter.getDefaultDelimiter());
            InputNumberStrings numberStrings = new InputNumberStrings(input, regex);
            Numbers numbers = new Numbers(numberStrings.split(regex.getDelimiterResult()));

            int sum = 0;
            for (String number : numbers.getNumbers()) {
                Number calculateNumber = new Number(number);
                if (calculateNumber.getNumber().equals("\"\"")) {
                    sum += 0;
                }

                if (!calculateNumber.getNumber().equals("\"\"")) {
                    sum += Integer.parseInt(calculateNumber.getNumber());
                }
            }

            System.out.println("결과 : " + sum);
        }

        if (isCustom(input)) {
            int customDelimiterEndIndex = input.indexOf("\\n");

            CustomDelimiter customDelimiter = new CustomDelimiter(input.substring(2, customDelimiterEndIndex));

            DelimiterResult customRegex = new DelimiterResult(defaultDelimiter.getDefaultDelimiter()
                    .substring(0, defaultDelimiter.getDefaultDelimiter().length() - 1)
                    + customDelimiter.getCustomDelimiter() + "]");

            InputNumberStrings numberStrings = new InputNumberStrings(input.substring(customDelimiterEndIndex + 2),
                    customRegex);
            Numbers numbers = new Numbers(numberStrings.split(customRegex.getDelimiterResult()));

            int sum = 0;
            for (String number : numbers.getNumbers()) {

                Number calculateNumber = new Number(number);
                if (calculateNumber.getNumber().equals("\"\"")) {
                    sum += 0;
                }

                if (!calculateNumber.getNumber().equals("\"\"")) {
                    sum += Integer.parseInt(calculateNumber.getNumber());
                }
            }
            System.out.println("결과 : " + sum);
        }
    }

    private static boolean isCustom(String input) {
        return input.startsWith("//");
    }
}