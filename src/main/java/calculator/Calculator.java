package calculator;

public class Calculator {

    public Separator separator = new Separator();

    public int getSum(String input) {
        int sum = 0;

        if (input.startsWith("//")) {
            input = separator.extractCustomSeparatorFrom(input);
        }

        for (String number : separator.getNumbersFrom(input)) {
            sum += getValidatedNumber(number);
        }

        return sum;
    }

    public int getValidatedNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        try {
//            숫자가 아닌 경우 예외 발생
            int num = Integer.parseInt(number.trim());

//            0, 음수일 경우 예외 발생
            if (num <= 0) {
                throw new IllegalArgumentException("음수와 0은 입력할 수 없습니다. ");
            }

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다. ");
        }
    }
}
