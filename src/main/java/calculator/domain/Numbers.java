package calculator.domain;

public class Numbers {

    public int[] parseToIntArray(String[] strNumbers) {
        int[] intNumbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            intNumbers[i] = parseToInt(strNumbers[i]);
        }

        return intNumbers;
    }

    private int parseToInt(String number) {
        try {
            int parseInt = Integer.parseInt(number);

            validatePositiveNumber(parseInt);

            return parseInt;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다.");
        }
    }

    private void validatePositiveNumber(int parseInt) {
        if (parseInt <= 0) {
            throw new IllegalArgumentException("음수와 0은 입력할 수 없습니다.");
        }
    }

}
