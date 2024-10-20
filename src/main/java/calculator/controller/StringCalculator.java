package calculator.controller;

import calculator.validator.StringValidator;
import java.util.List;

public class StringCalculator {

    private final StringValidator validator = new StringValidator();

    public int calculateInput(String input) {

        System.out.println(input);
        input = input.replace("\\n", "\n");
        System.out.println("Input string: \"" + input + "\"");

        String[] nums = validator.checkDelimiter(input);
        List<Integer> numbers = validator.checkNumber(nums);
        return validator.sumNumber(numbers);
    }

}
