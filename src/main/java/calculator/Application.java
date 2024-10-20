package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;


public class Application {
    static int calculate(String s) {
        //System.out.println(s);

        int sumResult = 0;

        if (s.equals("")) {
            return 0;
        }

        StringTokenizer st = new StringTokenizer(s, ",|:");

        while (st.hasMoreElements()) {
            String token = String.valueOf(st.nextElement());

            sumResult += Integer.parseInt(token);
        }

        return sumResult;
    }

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String inputString = Console.readLine();

        calculate(inputString);
        // System.out.println("결과 : " + calculate(inputString));

    }
}
