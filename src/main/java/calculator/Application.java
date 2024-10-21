package calculator;

public class Application {
    public static void main(String[] args) {
        // 숫자 덧셈 예시
        int result = add(5, 7, 8, 20);
        System.out.println("합: " + result);
    }

    public static int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
