package calculator;

import controller.CalculatorController;
import domain.Separator;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Separator separator = new Separator(Arrays.asList(",", ":"));

        CalculatorController controller = new CalculatorController(separator);
        controller.run();
    }
}
