package calculator;

import java.util.Arrays;

public class InputValidation {

    Input input = new Input();

    public void validate() {

        String userNumbers = input.inputNumbers();

        String normalSeparator = ",:";

        String[] numbers = new String[userNumbers.length() + 1];

        String separator;

        if (!userNumbers.contains("/")) {
            separator = "[" + normalSeparator + "]";
            numbers = userNumbers.split(separator);
        }

        if (userNumbers.contains("/")) {
            if ((userNumbers.substring(0, 2) + userNumbers.substring(3, 5)).equals("//\\n")) {
                separator = "[" + normalSeparator + userNumbers.charAt(2) + "]";
                numbers = userNumbers.substring(5).split(separator);
            } else {
                throw new IllegalArgumentException();
            }

        }

        numbers = Arrays.stream(numbers).map(e -> e.isEmpty() ? "0" : e).toArray(String[]::new);

        if (Arrays.stream(numbers).mapToInt(Integer::parseInt).filter(e -> e < 0).findAny().isPresent()) {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + Arrays.stream(numbers).mapToInt(Integer::parseInt).sum());


    }

}
