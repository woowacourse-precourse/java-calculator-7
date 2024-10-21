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
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
            input = input.substring(delimiterEndIndex + 1);    // 구분자 이후 문자열 추출
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}
