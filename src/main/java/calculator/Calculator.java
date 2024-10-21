package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

public class Calculator {
    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    // 문자열 입력
    private String getString() {
        String input;

        try {
            input = Console.readLine();
        } catch(NoSuchElementException e) {
            input = "0";
        }

        return input;
    }

    // 문자열 분리 및 숫자 리스트 반환
    private List<BigInteger> getNumList(String input) {
        return separator.separateString(input);
    }

    // 합산 결과 출력
    private void printResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = getString();
        List<BigInteger> numList = getNumList(input);
        printResult(
            new Adder(numList).addAll()
        );
    }
}
