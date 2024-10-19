package calculator.ui.view;

public class CalculatorOutputView {

    private static final StringBuilder BUFFER = new StringBuilder();

    public void splitAndSumOutput(int result) {
        BUFFER.append("결과 : ").append(result).append('\n');
        System.out.println(BUFFER);
        bufferClear();
    }

    private void bufferClear() {
        BUFFER.setLength(0);
    }

}
