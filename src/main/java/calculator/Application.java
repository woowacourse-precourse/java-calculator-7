package calculator;

import calculator.domain.prompt.Prompt;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        List<String> strings = prompt.separate("1,2:3");
        System.out.println(strings.toString());
    }

}
