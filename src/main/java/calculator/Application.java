package calculator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> stringList = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
        inputGuidelines.printInputGuidelines();


    }
}
