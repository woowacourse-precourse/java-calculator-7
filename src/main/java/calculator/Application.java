package calculator;

import calculator.controller.IOController;

public class Application {
    public static void main(String[] args) {

        IOController ioController = new IOController();
        ioController.run();
    }
}
