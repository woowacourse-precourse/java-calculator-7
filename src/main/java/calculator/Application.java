package calculator;

public class Application {
    public static void main(String[] args) {
        try {
            Parsing parse = new Parsing();

            String input = GetInput.getInput();
            long ret = parse.calculate(input);

            System.out.println("결과 : " + ret);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
