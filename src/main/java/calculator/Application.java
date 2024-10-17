package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        User input = new User(Console.readLine());
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

        if (!input.isCustom()) {
            Numbers numbers = crateNumbers(defaultDelimiter, input);

            int sum = 0;
            for (String number : numbers.getNumbers()) {
                Number calculateNumber = new Number(number);
                sum += Integer.parseInt(calculateNumber.getNumber());
            }

            System.out.println("결과 : " + sum);
        }

        if (input.isCustom()) {
            int customDelimiterEndIndex = input.getUser().indexOf("\\n");

            CustomDelimiter customDelimiter = new CustomDelimiter(
                    input.getUser().substring(2, customDelimiterEndIndex));
            DelimiterResult customRegex = new DelimiterResult(defaultDelimiter.getDefaultDelimiter()
                    .substring(0, defaultDelimiter.getDefaultDelimiter().length() - 1)
                    + customDelimiter.getCustomDelimiter() + "]");

            String inputWithoutDelimiter = input.getUser().substring(customDelimiterEndIndex + 2);
            InputNumberStrings numberStrings = new InputNumberStrings(inputWithoutDelimiter, customRegex);
            Numbers numbers = new Numbers(numberStrings.split(customRegex.getDelimiterResult()));

            int sum = 0;
            for (String number : numbers.getNumbers()) {
                Number calculateNumber = new Number(number);
                sum += Integer.parseInt(calculateNumber.getNumber());
            }
            System.out.println("결과 : " + sum);
        }
    }

    private static Numbers crateNumbers(DefaultDelimiter defaultDelimiter, User input) {
        DelimiterResult regex = new DelimiterResult(defaultDelimiter.getDefaultDelimiter());
        InputNumberStrings numberStrings = new InputNumberStrings(input.getUser(), regex);
        Numbers numbers = new Numbers(numberStrings.split(regex.getDelimiterResult()));
        return numbers;
    }


}