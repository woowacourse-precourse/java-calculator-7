package calculator.view;

import calculator.util.SplitNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class InputView {
    public List<Integer> inputNumbers() {
        String numbers = Console.readLine();
        if (numbers.equals("")){
            return Collections.emptyList();
        }else{

            return SplitNumber.checkNumbers(numbers);
        }
    }
}
