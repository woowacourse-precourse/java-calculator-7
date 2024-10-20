package controller;

import calculatorservice.DelimiterService;
import camp.nextstep.edu.missionutils.Console;

public class RunCalculator {
    public void run() {
        DelimiterService delimiterService = new DelimiterService();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 문자를 입력받고 앞뒤 공백을 제거.

        if (input.isEmpty()) { // 빈 입력이면 0을 반환
            System.out.print("결과 : " + 0);
            return;
        }
        int sumResult = delimiterService.DelimiterProcess(input);
        System.out.print("결과 : " + sumResult);
    }
}
