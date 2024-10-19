package calculator;

public class NumberParser {

    public int[] parse(String input, String delimiter) {
        String[] values = splitInput(input, delimiter);
        return convertToIntegers(values);
    }

    // 문자열 분리 메서드
    private String[] splitInput(String input, String delimiter) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        return input.split(delimiter);
    }

    // 숫자 변환 메서드
    private int[] convertToIntegers(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            if (values[i].isEmpty()) {
                // 빈 문자열인 경우 0으로 처리
                numbers[i] = 0;
            } else {
                try {
                    numbers[i] = Integer.parseInt(values[i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 포함되어 있습니다: " + values[i]);
                }

                if (numbers[i] < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + numbers[i]);
                }
            }
        }
        return numbers;
    }
}
