package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Calculator {
    int res;

    Calculator() {
        res = 0;
    }

    void on() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        calculate(inputString);
    }

    private void calculate(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString.replace(":", " ").replace(",", " "), " ");
        while ( st.hasMoreTokens() ) res += Integer.parseInt(st.nextToken());

        System.out.println("결과 : " + res);
    }

}
