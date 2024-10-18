package calculator;

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
        
    }

}
