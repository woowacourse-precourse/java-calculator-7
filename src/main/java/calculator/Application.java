package calculator;

public class Application {
    public static void main(String[] args) {
        CalculateService calculateService = new CalculateService(new NormalCalculatorImpl(), new SpecialCalculatorImpl());
        CalculatorController controller = new CalculatorController(calculateService);

        //입력을 받아서 수행할 수 있는 부분을 추가
        if (args.length > 0) {
            String input = args[0];
            controller.processCalculation(input);
    }
}
