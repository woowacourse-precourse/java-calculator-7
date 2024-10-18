package calculator;

public class Calculator {
    public int total;

    public void getTotal(SplitStringWithSeparator splitStringWithSeparator) {
        for (String number : splitStringWithSeparator.processedInput) {
            total += Integer.parseInt(number);
        }
    }
}
