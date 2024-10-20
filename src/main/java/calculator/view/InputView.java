package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    public List<String> getOperand(){
        List<String> inputs = new ArrayList<>();
        inputs.add(Console.readLine());

        if(!Pattern.matches("^\\d.*", inputs.get(0)) && !inputs.get(0).isEmpty()) {
            inputs.add(Console.readLine());
        }
        return inputs;
    }
}
