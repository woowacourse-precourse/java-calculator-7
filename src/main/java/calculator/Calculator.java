package calculator;

public class Calculator {
    private long result;

    public Calculator() {
    }

    public long sum(InputData inputData) {
        String numbers = inputData.getNumbers();
        String delimiters = inputData.getDelimiters();

        if (numbers.isEmpty() || delimiters.isEmpty()) {
            return 0;
        }

        String[] strArr = numbers.split(delimiters);
        try {
            for (String str : strArr) {
                long num = Long.parseLong(str);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                result += num;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return result;
    }
}
