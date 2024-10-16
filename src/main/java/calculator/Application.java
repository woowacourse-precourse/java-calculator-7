package calculator;

public class Application {
    public static void main(String[] args) {
        final ExpressionInputReader expressionInputReader = new ExpressionInputReader();

        final String input = expressionInputReader.read();
        System.out.println(input);
        final Adder adder = new Adder(input, expressionInputReader.getDelimiters());

        System.out.println("결과 : " + adder.run());
    }
}
