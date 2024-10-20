package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        IO io = new IO();
        Logic logic = new Logic();

        String str = io.input();
        io.output(logic.calculate(str));
    }
}
