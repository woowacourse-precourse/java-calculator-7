package calculator;

public class Application {

    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        StringCalculator calculator=new StringCalculator(delimiter);
        calculator.run();
    }
}
