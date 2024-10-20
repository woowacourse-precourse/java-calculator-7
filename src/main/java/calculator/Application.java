package calculator;

import calculator.controller.StringController;

public class Application {
    public static void main(String[] args) {
        StringController stringController = new StringController();
        stringController.start();
    }
}
