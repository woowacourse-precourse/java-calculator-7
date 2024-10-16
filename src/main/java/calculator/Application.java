package calculator;

import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        String input = view.requestInput();
    }
}
