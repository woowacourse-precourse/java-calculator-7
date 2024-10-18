package calculator.io;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void printResult(final Number value) {
        System.out.println("결과 : " + value);
    }

}
