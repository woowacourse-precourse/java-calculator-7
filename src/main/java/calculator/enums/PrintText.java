package calculator.enums;

public enum PrintText {
    PROMPT_FOR_INPUT("덧셈할 문자열을 입력해 주세요."),
    PRINT_RESULT("결과 : ");

    private final String printText;

    PrintText(String printText) {
        this.printText = printText;
    }

    public String getPrintText() {
        return printText;
    }
}
