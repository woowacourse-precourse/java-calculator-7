package calculator.ui.view;

import java.math.BigInteger;

public class CalculatorOutputView {

    private static final StringBuilder BUFFER = new StringBuilder();

    public void splitAndSumOutput(BigInteger result) {
        BUFFER.append("결과 : ").append(result).append('\n');
        System.out.println(BUFFER);
        bufferClear();
    }

    private void bufferClear() {
        BUFFER.setLength(0);
    }

}
