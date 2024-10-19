package calculator;

public class Application {
    public static void main(String[] args) throws Exception {

        try (ConsoleIOHandler handler = new ConsoleIOHandler()) {
            final Expression expr = Expression.parse(handler.read());

            final Adder adder = new Adder(expr.getDelimiters(), expr.getOperands());
            final int result = adder.sum();
            handler.print(result);
        }
    }
}
