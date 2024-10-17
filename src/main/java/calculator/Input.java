package calculator;

import java.util.List;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    String[] separatorInput(List<String> separator) {
        String regex = String.join("|", separator);
        String[] splitStr = input.split(regex);

        return splitStr;
    }

    static int[] changeInteger(String[] splitStr) {
        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            numbers[i] = Integer.parseInt(splitStr[i]);
        }
        return numbers;
    }
}
