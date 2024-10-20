package calculator;



public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Calculator calculator = new Calculator();
        UserOutput userOutput = new UserOutput();

        String input = userInput.getUserInput();
        int result = calculator.getResult(input);
        userOutput.printResult(result);
    }
}
