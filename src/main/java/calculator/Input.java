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
        try {
            for (int i = 0; i < splitStr.length; i++) {
                numbers[i] = Integer.parseInt(splitStr[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
        return numbers;
    }
}
