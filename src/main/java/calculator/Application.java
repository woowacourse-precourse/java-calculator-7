package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> stringList = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
        inputGuidelines.printInputGuidelines();
        String inputData = Console.readLine();

        Calculator calculator = new Calculator(stringList,inputData);
        System.out.println("결과 : "+calculator.run());
    }
}
