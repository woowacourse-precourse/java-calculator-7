package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.close;


public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        Calculator c = new Calculator(input);
        long result = c.getSum();
        System.out.println("결과 : "+result);
        close();
    }
}
