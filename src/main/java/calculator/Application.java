package calculator;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String expression = InputHandler.getInput();
        Integer calculated = Calculator.calculate(expression);
        System.out.println("결과 : " + calculated);
    }
}
