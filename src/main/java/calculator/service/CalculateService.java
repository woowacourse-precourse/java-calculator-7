package calculator.service;

import calculator.model.UserInput;

public class CalculateService {

    /***
     * 사용자의 문자열을 기반으로 덧셈을 수행
     * @param userInput : 사용자가 입력한 문자열
     * @return : 계산 결과를 리턴
     */
    public long calculate(UserInput userInput) {
        return userInput.sumCalculate();
    }
}
