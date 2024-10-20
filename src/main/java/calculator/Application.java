package calculator;

import calculator.controller.SplitController;

public class Application {
    public static void main(String[] args) {
        SplitController splitController = new SplitController();
        splitController.process();
    }
}
