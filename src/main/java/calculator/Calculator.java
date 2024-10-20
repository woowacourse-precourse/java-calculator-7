package calculator;

public class Calculator {
    public void startCalculate(){
        String userInput = Input.getUserInput();
        int[] digits = NumberExtractor.getDigits(userInput);
        int addResult = addCalculate(digits);
        Output.printOutput(addResult);
    }

    public int addCalculate(int[] digits) {
        int sum = 0;
        for(int digit : digits) {
            sum += digit;
        }
        return sum;
    }
}