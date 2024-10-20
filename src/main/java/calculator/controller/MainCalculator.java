package calculator.controller;

import calculator.service.MainService;
import camp.nextstep.edu.missionutils.Console;

public class MainCalculator {

    public static void start(){
        MainService mainService = new MainService();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        System.out.println("결과 : " + mainService.sumDelimitedStr(str));

    }
}
