package calculator;

public class Adder {
    Number number = new Number();

    public void sumNumbers(String[] numbers) {
        int sum = 0;
        OutputHandler outputHandler = new OutputHandler();
        for (String num : numbers) {
            sum += number.validateAndParseNumber(num);
        }
        outputHandler.printSumResult(sum);
    }
}
