package calculator;

public class Extraction {

    private String delimiter;
    private String input;

    public Extraction(String input) {
        this.input = input;
        this.delimiter = ",|:";
    }

    public int[] extract() {
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex > 2) {
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 2);
            } else {
                throw new IllegalArgumentException();
            }
        }

        String[] stringArr = input.split(delimiter);
        int[] numbers = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            int num;
            try {
                num = Integer.parseInt(stringArr[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (num < 0) {
                throw new IllegalArgumentException();
            }
            numbers[i] = num;
        }
        return numbers;
    }
}
