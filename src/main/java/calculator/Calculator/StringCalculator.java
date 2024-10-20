package calculator.Calculator;

public class StringCalculator implements Calculator {
    @Override
    public int sumOfStrings(String[] input) {
        int sum = 0;
        try {
            for (String num : input) {
                sum += parseNumber(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자가 포함되어 있습니다.");
        }
        return sum;
    }

    private int parseNumber(String num) {
        int intNum = Integer.parseInt(num);
        if (intNum <= 0) {
            throw new IllegalArgumentException("음수 혹은 0이 포함되어 있습니다." + num);
        }
        return intNum;
    }
}
