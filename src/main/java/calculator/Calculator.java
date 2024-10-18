package calculator;

public class Calculator {

    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private OutputPrinter printer = new OutputPrinter();
    private InputReader reader = new InputReader();

    public void run() {
        printer.println(GUIDE_MESSAGE);
        String command = reader.read();
    }

}
