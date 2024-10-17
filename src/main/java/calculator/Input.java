package calculator;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] separatorInput(Separator separator) {
        String regex = separator.getRegex();
        String[] splitStr = input.split(regex);

        return splitStr;
    }

    public int[] changeInteger(String[] splitStr) {
        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            numbers[i] = Integer.parseInt(splitStr[i]);
        }
        return numbers;
    }
}
