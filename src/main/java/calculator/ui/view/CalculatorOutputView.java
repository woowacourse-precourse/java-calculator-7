package calculator.ui.view;

import java.math.BigInteger;

public class CalculatorOutputView {

    private static final StringBuilder BUFFER = new StringBuilder();

    public void splitAndSumOutput(String result) {
        BUFFER.append("결과 : ").append(result).append('\n');
        bufferClear();
    }

    private void bufferClear() {
        System.out.println(BUFFER);
        BUFFER.setLength(0);
    }

}
