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
                try {
                    numbers[i] = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("계산식의 형태가 올바르지 않습니다.");
                }
            }
        }
    }

    // 구분한 문자열들(숫자들)이 모두 범위(0 이상이며 `Integer.MAX_VALUE` 이하) 이내인지 확인한다.
}
