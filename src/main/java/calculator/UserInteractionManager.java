package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class UserInteractionManager {
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }

    public void printOutput(BigInteger result) {
        System.out.print("결과 : " + result);
    }
}
