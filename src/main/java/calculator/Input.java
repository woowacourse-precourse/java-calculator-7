package calculator;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] splitBySeparator(Separator separator) {
        if (input.isEmpty() || input == null) {
            return new String[0];
        }

        String regex = separator.getRegex();
        return input.split(regex);
    }

    public int[] convertToIntArray(String[] splitStr) {
        if (splitStr.length == 0) {
            return new int[0];
        }

        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            numbers[i] = Integer.parseInt(splitStr[i]);
        }
        return numbers;
    }
}
