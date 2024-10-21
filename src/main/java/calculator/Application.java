package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 기본 구분자 쉼표와 콜론으로 문자열 분리
        String[] numbers = input.split(",|:");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}
