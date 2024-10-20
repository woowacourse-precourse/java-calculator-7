package calculator.io;

import static calculator.global.instance.Messages.DESCRIPTION;
import static calculator.global.instance.Messages.INPUT_PROMPT;
import static calculator.global.instance.Messages.RESULT;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorIO {

    public static void add() {
        System.out.println(DESCRIPTION);
        System.out.println(INPUT_PROMPT);
        try {
            String stringInput = Console.readLine(); // 사용자 입력 받기
            int result = CalculatorService.add(stringInput); // 덧셈 계산
            System.out.println(RESULT + result);
        } finally {
            Console.close(); // Scanner 자원 해제
        }
    }
}
