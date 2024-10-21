package calculator;

import calculator.Controller.CalculateC;
import calculator.Model.CalculateM;
import calculator.View.CalculateV;

public class Application {
    public static void main(String[] args) {
        CalculateM model = new CalculateM();
        CalculateV view = new CalculateV();
        CalculateC controller = new CalculateC(model, view);
        controller.run();
    }
}