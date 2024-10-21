package calculator;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.dto.CalculatorResultResponse;
import calculator.dto.NumberRequest;

public class CalculatorView {

    public NumberRequest readInput() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String word = readLine();

        close();

        return new NumberRequest(word);
    }

    public void resultResponseMessage(CalculatorResultResponse response) {
        System.out.println("결과 : " + response.sumResult());
    }
}
