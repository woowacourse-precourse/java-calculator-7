package calculator;

import calculator.model.CalculatorModel;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private final CalculatorModel calculatorModel;

    public Application(CalculatorModel calculatorModel) {
        this.calculatorModel = calculatorModel;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        ArrayList<String> separate = new ArrayList<>(Arrays.asList(",", ":"));
        if (calculatorModel.CustomDiscrimination(str)) {
            separate.add(calculatorModel.CustomExtraction(str));
            System.out.println(
                    "결과 : " + calculatorModel.sumCalculator(str.substring(str.indexOf("\\n") + 2), separate));
        } else {
            System.out.println("결과 : " + calculatorModel.sumCalculator(str, separate));
        }
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        Application app = new Application(calculatorModel);
        app.run();

    }
}
