package calculator.output;

import calculator.domain.SumCalculator;

public class OutputHandler {
    private final SumCalculator sumCalculator;

    public OutputHandler(SumCalculator sumCalculator) {
        this.sumCalculator = sumCalculator;
    }

    public String createOutputMessage() {
        return "결과 : " + sumCalculator.getResult();
    }

    public void output() {
        System.out.println(createOutputMessage());
    }
}
