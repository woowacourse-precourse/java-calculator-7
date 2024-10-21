package calculator;

public class CalculateM {
    public int calculate(String input) {
        validateInput(input);

        String[] parts = splitInput(input);

        return 0;


    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private String[] splitInput(String input) {
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                delimiter = input.substring(2, delimiterEndIndex);
                numbers = input.substring(delimiterEndIndex + 2);
            } else {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
        }

        return new String[]{delimiter, numbers};
    }
}
