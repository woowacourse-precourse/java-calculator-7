package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int toPositiveInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
        }
        return num;
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += toPositiveInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
            }
        }
        return sum;
    }
}
