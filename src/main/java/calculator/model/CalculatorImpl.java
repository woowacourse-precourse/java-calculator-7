package calculator.model;

import java.util.StringTokenizer;

public class CalculatorImpl implements Calculator {

    private final String string;

    public CalculatorImpl(String string) {
        this.string = string;
    }

    @Override
    public int calculate() {
        int calcResult = 0;

        // 10.16 Ver 1
        // First It doesn't matter about custom delimiter
        // Just Only , and :
        StringTokenizer st = new StringTokenizer(this.string,",:");
        while (st.hasMoreTokens()){
            calcResult += Integer.parseInt(st.nextToken());
        }

        return calcResult;
    }
}
