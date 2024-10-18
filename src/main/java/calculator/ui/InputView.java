package calculator.ui;

import calculator.domain.Result;
import calculator.util.Util;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final Util util;

    public InputView(Util util) {
        this.util = util;
    }

    public Result readText(){
        String text = readLine();
        List<Integer> numbers = util.extract(text);
        return new Result(numbers);
    }
}
