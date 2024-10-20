package calculator;

import calculator.controller.PlayerController;

public class Application {
    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();
        playerController.process();
    }
}
