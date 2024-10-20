package calculator;
import camp.nextstep.edu.missionutils.Console;
import Factory.SeparatorFactory;
import separator.CustomSeparatorFormat;
import view.InputGuidelines;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> defaultSeparators = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(defaultSeparators);
        inputGuidelines.printInputGuidelines();
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),Console.readLine());

        Calculator calculator = new Calculator(separatorFactory.generateSeparators());
        System.out.println("결과 : "+calculator.run());
    }
}
