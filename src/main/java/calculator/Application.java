package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //String inputString = "//-\n1,2:3-9";

        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();

        String inputString = calculatorIO.input();

        calculator.getDivision(inputString);
        //calculator.getNumbers("");

        System.out.println(calculator.calculateNumber());
    }
}
