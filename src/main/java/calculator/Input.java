package calculator;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] splitBySeparator(Separators separators) {
        if (input.isEmpty()) {
            return new String[0];
        }

        String regex = separators.getRegex();
        return input.split(regex);
    }

    public int[] convertToIntArray(String[] splitStr) {
        if (splitStr.length == 0) {
            return new int[0];
        }

        int[] numbers = parseToIntArray(splitStr);
        validPositiveArray(numbers);
        return numbers;
    }

    private static int[] parseToIntArray(String[] splitStr) {
        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            try {
                numbers[i] = Integer.parseInt(splitStr[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        return numbers;
    }

    private static void validPositiveArray(int[] numbers) {
        for (int number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다.");
            }
        }
    }
}
