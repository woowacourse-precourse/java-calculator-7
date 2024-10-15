package calculator;

public class Application {
    public static void main(String[] args) {
        String inputLine = CalculatorInput.getString();
        CalculatorParser parser = new CalculatorParser(inputLine);
        Calculator casio = new Calculator(parser.getCustomDelimiter());
        double result = casio.getResult(parser.getExpression());

        CalculatorOutput.print(result);
    }
}
