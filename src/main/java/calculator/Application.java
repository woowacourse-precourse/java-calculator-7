package calculator;

public class Application {
    public static void main(String[] args) {
            Parsing parse = new Parsing();

            String input = GetInput.getInput();
            long ret = parse.calculate(input);

            System.out.println("결과 : " + ret);
    }
}
