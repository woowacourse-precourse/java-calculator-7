package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("결과 : " + calculatorService.ensureValidInput(input));
    }
}
