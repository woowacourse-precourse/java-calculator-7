package calculator;

import calculator.cli.InputView;
import calculator.domain.Separator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Separator separator = new Separator(inputView.inputMessage());

        for (String str : separator.getElements()) {
            System.out.println(str);
        }
    }
}
