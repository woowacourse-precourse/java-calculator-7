package calculator.model;

import java.util.Set;

public class LongCalculatorModel extends CalculatorModel {

    private long[] numbers;
    private long resultNumber;


    public LongCalculatorModel(Set separators) {
        this.separators = separators;
        this.resultNumber = 0;
    }

    @Override
    public void generateResult() {
        this.result = Long.toString(resultNumber);
    }

    public void setResultNumber(long resultNumber) {
        this.resultNumber = resultNumber;
    }

    public void setNumbers(long[] numbers) {
        this.numbers = numbers;
    }

    public long[] getNumbers() {
        return this.numbers;
    }

    public long getResultNumber() {
        return this.resultNumber;
    }
}
