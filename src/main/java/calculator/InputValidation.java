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
        
        if (userNumbers.contains("/")) {
            if ((userNumbers.substring(0, 2) + userNumbers.substring(3, 5)).equals("//\\n")) {
                separator = "[" + normalSeparator + userNumbers.charAt(2) + "]";
                numbers = userNumbers.substring(5).split(separator);
            } else {
                throw new IllegalArgumentException();
            }

        }

    }

}
