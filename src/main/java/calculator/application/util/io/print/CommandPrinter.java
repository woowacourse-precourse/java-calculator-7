package calculator.application.util.io.print;

public final class CommandPrinter {

    private CommandPrinter() {}

    private static final String REQUEST_INPUT = "덧셈할 문자열을 입력해 주세요.";

    public static void printStartCommand() {
        System.out.println(REQUEST_INPUT);
    }
}
