package calculator.io;

public class InputHandler {
    public static String makeDelimiterNumberString() {
        Printer.printMessage("덧셈할 문자열을 입력해 주세요.");
        Printer.printNewLine();

        return Reader.getString();
    }
}
