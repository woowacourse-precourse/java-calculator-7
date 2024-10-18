package calculator.model;

public class Calculator {
    private final Mathematician mathematician;
    private final NumberFinder numberFinder;

    public Calculator(Mathematician mathematician, NumberFinder numberFinder) {
        this.mathematician = mathematician;
        this.numberFinder = numberFinder;
    }

    public int sumOfNumInAlphaNum(String alphaNum) {
        int[] correctNums = numberFinder.findNumbersFrom(alphaNum);
        return mathematician.sum(correctNums);
    }
}
