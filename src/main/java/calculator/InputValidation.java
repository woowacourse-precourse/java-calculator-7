package calculator;

import java.util.Arrays;

public class InputValidation {

    Input input = new Input();

    String userNumbers = input.inputNumbers();

    String[] numbers;


    public boolean checkSeparator(String userInput) {
        if (userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    public void isDigitNormalNumbers(String[] numbers) {

        for (String str : numbers) {
            if (!str.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isPositiveNumbers(String[] numbers) {
        if (Arrays.stream(numbers).mapToInt(Integer::parseInt).filter(e -> e < 0).findAny().isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public String[] transEmptyNumbers(String[] numbers) {
        return Arrays.stream(numbers).map(e -> e.isEmpty() ? "0" : e).toArray(String[]::new);
    }

    public void validate() {

        CustomInputValidation customInputValidation = new CustomInputValidation(checkSeparator(userNumbers),
                userNumbers);

        numbers = customInputValidation.getNumbers();
        isDigitNormalNumbers(numbers);
        System.out.println(Arrays.toString(numbers));
        numbers = transEmptyNumbers(numbers);

        isPositiveNumbers(numbers);

        System.out.println("결과 : " + Arrays.stream(numbers).mapToInt(Integer::parseInt).sum());

    }

}
