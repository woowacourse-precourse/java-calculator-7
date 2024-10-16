package calculator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> stringList = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
        inputGuidelines.printInputGuidelines();

        Calculator calculator = new Calculator(inputGuidelines.getDefaultSeparator());
        System.out.println("결과 : "+calculator.run());
    }
}
