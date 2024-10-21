package calculator;

public class Application {
    public static void main(String[] args) {
        Out.printMessage("덧셈할 문자열을 입력해 주세요.");
        String input = In.readLine();
        Calculator calculator = new Calculator();
        int result = calculator.add(input);
        Out.printResult(result);
    }
}