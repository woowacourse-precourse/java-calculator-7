package calculator;

public class Application {
    public static void main(String[] args) {

        CalculatorController calCon = new CalculatorController(new View());
        calCon.start();
    }
}
