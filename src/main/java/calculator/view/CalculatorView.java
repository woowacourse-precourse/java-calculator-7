package calculator.view;

import calculator.dto.ResultDTO;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void getResult(Long result) {
        ResultDTO resultDTO = new ResultDTO(result);
        System.out.println(resultDTO.toString());
    }

}
