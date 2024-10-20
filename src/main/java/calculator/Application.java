package calculator;

public class Application {
    public static void main(String[] args) {
        final String inputLine = CalculatorInput.getLine();
        final CalculatorParser parser = new CalculatorParser(inputLine);
        final Calculator casio = new Calculator(parser.getCustomDelimiter());
        final double result = casio.getResult(parser.getExpression());

        CalculatorOutput.print(result);
    }
}
