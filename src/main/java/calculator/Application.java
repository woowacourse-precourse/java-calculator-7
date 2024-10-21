package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Console.close;


public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine(); //*\n2*3,4
        Calculator c = new Calculator(str);
        long result = c.getSum();
        System.out.println("결과 : "+result);
        close();
    }
}
