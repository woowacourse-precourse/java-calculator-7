package calculator.controller;

import calculator.service.CalculateService;

//사용자의 Input 과 Output 을 담당하며, calculate service 를 이용할 수 있는 클래스
public class CalculateController {

    private final CalculateService calculateService = new CalculateService();

    // userInput 을 받아 caculateService 에 넘김.
    public long insertUserInput(final String userInput) {

        if (userInput.isEmpty()) {
            return 0L;
        }

        return calculateService.calculate(userInput);

    }
}
