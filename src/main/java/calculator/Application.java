package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Parsing parse = new Parsing();

        String input = GetInput.getInput();
        long ret = parse.calculate(input);

    }
}
