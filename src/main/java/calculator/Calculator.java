package calculator;

public class Calculator { //TODO: 입력된 숫자들을 모두 더해서 반환
    public static Integer calculate(String expression) {
        if (InputHandler.isNullOrEmpty(expression)) {
            return 0;
        }
        return Integer.parseInt(expression);
    }
}
