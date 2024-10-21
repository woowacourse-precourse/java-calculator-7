package calculator;

public class Char2Num {
    Long[] numbers;

    void convert(String[] splitInput) {
        if (isEmpty(splitInput)) {
            this.numbers = zeroArray();
            return;
        }
        Long[] numbers = new Long[splitInput.length];
        int idx = 0;
        for (String input: splitInput) {
            if (!input.equals("")) {
                numbers[idx++] = Long.parseLong(input);
            }
        }
        this.numbers = numbers;
    }

    Boolean isEmpty(String[] splitInput) {
        for (String input: splitInput) {
            if (!input.equals("")) {
                return false;
            }
        }
        return true;
    }

    Long[] zeroArray() {
        return new Long[]{0L};
    }

}
