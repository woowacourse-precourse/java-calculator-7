package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            System.out.println("결과 : " + calculator.add("-1,2,3"));
        } catch (IllegalArgumentException e) {
            System.out.println("에러 발생: " + e.getMessage());  // 에러 메시지 출력
        }
    }
}
