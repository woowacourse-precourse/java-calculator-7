package calculator;

public class Calculator {

    public void run() {
        String rawString = new Input().getNumberWithSeparator();
        new Delimiters(rawString);
        new Output().printResult(new Adder(new NumberExtractor(rawString).getExtractedNumbers()).sumNumbers());
    }
}
