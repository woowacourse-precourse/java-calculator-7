package calculator;

import calculator.delimiter.CustomDelimiterService;
import calculator.delimiter.Delimiter;
import calculator.delimiter.Delimiters;
import calculator.util.console.Console;
import calculator.util.integer.IntegerUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService();

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Delimiters delimiters = new Delimiters(getDelimiters(input));

        List<String> numberTokens = delimiters.split(customDelimiterService.trimCustomDelimiter(input));
        try {
            List<Integer> numbers = IntegerUtils.parsePositiveIntegers(numberTokens);
            int sum = IntegerUtils.sum(numbers);
            Console.print("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private static List<Delimiter> getDelimiters(String input) {
        List<Delimiter> delimiters = new ArrayList<>(getDefaultDelimiters());
        customDelimiterService.extract(input).ifPresent(delimiters::add);
        return delimiters;
    }

    private static List<Delimiter> getDefaultDelimiters() {
        List<Delimiter> delimiters = new LinkedList<>();
        delimiters.add(new Delimiter(","));
        delimiters.add(new Delimiter(":"));
        return delimiters;
    }
}
