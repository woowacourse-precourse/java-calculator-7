package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();
        controller.run();
    }

}
