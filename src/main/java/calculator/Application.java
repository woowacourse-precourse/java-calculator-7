package calculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Input input = new Input();
        if (input.isValid()) {
            int result = Calculator.sum(input.getNumbersFromInput());
            System.out.println("결과 : " + result);
        } else {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
