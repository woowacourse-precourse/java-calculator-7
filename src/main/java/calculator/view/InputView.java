package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    // private 클래스이므로 외부에서 접근할 수 없다.
    private static class InputViewHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public String getNotSeparatedString() {
        return Console.readLine();
    }
}
