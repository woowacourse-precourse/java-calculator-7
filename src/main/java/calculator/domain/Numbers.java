package calculator.domain;

public class Numbers {

    private String[] parts;
    private int[] numbers;

    public Numbers(String[] parts) {
        this.parts = parts;
        this.numbers = new int[parts.length];
        parseAndValidateNumbers();
    }

    // 문자열 배열을 숫자로 변환하고, 문자가 포함되어 있으면 예외를 발생시킴
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


}
