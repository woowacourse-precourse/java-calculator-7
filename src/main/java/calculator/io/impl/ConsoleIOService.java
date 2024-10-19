package calculator.io.impl;

import calculator.io.IOService;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleIOService implements IOService {

    @Override
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void printResult(long result) {
        System.out.println("결과 : " + result);
    }

    @Override
    public void close() {
        Console.close();
    }

}
