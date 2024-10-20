package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        IO io = new IO();
        String input = io.receiveInput();

        InputData data = new InputData(input);

        Calculator calculator = new Calculator();
        long result = calculator.sum(data);

        io.sendOutput(result);
    }
}
