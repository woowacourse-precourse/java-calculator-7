package calculator;

public class Application {

    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        Parser parser = new Parser();
        StringCalculator calculator=new StringCalculator(delimiter,parser);
        calculator.run();
    }
}
