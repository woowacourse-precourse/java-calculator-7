package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    private final FormulaSeparator formulaSeparator = new FormulaSeparator();

    public List<Integer> createFormula() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String formula = Console.readLine();
        return formulaSeparator.getNumbers(formula);
    }

}
