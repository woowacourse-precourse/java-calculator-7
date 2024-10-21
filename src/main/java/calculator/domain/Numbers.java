package calculator.domain;

public class Numbers {

    private String[] parts;
    private int[] numbers;

    public Numbers(String[] parts) {
        this.parts = parts;
        this.numbers = new int[parts.length];
        parseAndValidateNumbers();
    }

    // String 배열을 int 배열로 변환하고, 문자가 포함되어 있거나 숫자의 범위가 벗어나면 예외를 발생시킴
    private void parseAndValidateNumbers() {
        for (int i = 0; i < parts.length; i++) {
            String number = parts[i];

            if (number.isEmpty()) {
                numbers[i] = 0;
            } else {
                if (!number.matches("-?\\d+")) {
                    throw new IllegalArgumentException("계산식의 형태가 올바르지 않습니다.");
                }

                try {
                    numbers[i] = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자의 범위가 범위 밖입니다.");
                }
            }
        }
    }

    public int calculate() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            try {
                sum = Math.addExact(sum, numbers[i]);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("더하기 연산에서 오버플로우가 발생했습니다.");
            }
        }

        return sum;
    }
}
