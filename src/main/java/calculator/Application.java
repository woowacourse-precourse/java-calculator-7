package calculator;

import calculator.delimiter.CustomDelimiterService;
import calculator.delimiter.Delimiter;
import calculator.delimiter.Delimiters;
import calculator.util.integer.IntegerUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService();

    public static void main(String[] args) {

        List<Delimiter> delimiterList = new LinkedList<>();
        delimiterList.add(new Delimiter(","));
        delimiterList.add(new Delimiter(":"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        Optional<Delimiter> delimiter = customDelimiterService.extract(input);
        if (delimiter.isPresent()) {
            int newLineIndex = input.indexOf(CustomDelimiterService.CUSTOM_DELIMITER_SUFFIX);
            input = input.substring(newLineIndex + CustomDelimiterService.CUSTOM_DELIMITER_SUFFIX.length());
            delimiterList.add(delimiter.get());
        }

        Delimiters delimiters = new Delimiters(delimiterList);

        List<String> numberTokens = delimiters.split(input);
        try {
            List<Integer> numbers = IntegerUtils.parsePositiveIntegers(numberTokens);
            int sum = IntegerUtils.sum(numbers);
            System.out.print("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
        }
    }
}
