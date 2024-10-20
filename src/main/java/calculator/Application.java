package calculator;

public class Application {
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();

        String userInput = sc.input();

        if (sc.isNullOrEmpty(userInput)) {
            sc.printResult(0);
            return;
        }
        if (userInput.matches("[0-9]")) {
            sc.printResult(Integer.parseInt(userInput));
            return;
        }

        userInput = sc.filterCustomSeparatorPattern(userInput);
        sc.printResult(sc.splitAndSum(userInput));
    }
}
