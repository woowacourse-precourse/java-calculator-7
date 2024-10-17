package calculator;

public class StringCalculator {
    public String[] splitInput(String input) {
        if (input.startsWith("//")) {
            int customIdx = input.indexOf("\n");
            String custom = input.substring(2, customIdx);
            String numberString = input.substring(customIdx + 1);

            return numberString.split(custom);
        }

        return input.split("[,:]");
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        int sum = 0;

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + number);
            }
        }

        return sum;
    }
}