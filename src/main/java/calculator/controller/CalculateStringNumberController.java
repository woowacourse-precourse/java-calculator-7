package calculator.controller;

import calculator.service.CalculateStringNumberService;
import camp.nextstep.edu.missionutils.Console;

public class CalculateStringNumberController {

    public void getResult() {
        System.out.println("이곳에 값을 입력하세요 : ");
        String input = Console.readLine();

        CalculateStringNumberService service = new CalculateStringNumberService();
        Integer totalSum = service.calculateStringNumber(input);

        System.out.println("결과 : " + totalSum);
    }

}
