package calculator;

import controller.Controller;

public class Application {
    public static void main(String[] args) {

        final Controller controller = new Controller();
        controller.processUserInput();
    }
}
