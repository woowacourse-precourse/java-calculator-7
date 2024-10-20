package calculator;

import calculator.controller.CalculateStringNumberController;

public class Application {
    public static void main(String[] args) {
        CalculateStringNumberController calculateStringNumberController = new CalculateStringNumberController();

        calculateStringNumberController.getResult();
    }
}
