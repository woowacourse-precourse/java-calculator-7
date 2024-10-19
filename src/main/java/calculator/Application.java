package calculator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String value = readLine();
        List<String> valuesToCalculate = new ArrayList<>();
        valuesToCalculate.add(value);
    }
}
