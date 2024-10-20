package calculator;

import calculator.dto.NumberRequest;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorView {
    public NumberRequest welcomeMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String word = readLine();

        close();

        return new NumberRequest(word);
    }
}
