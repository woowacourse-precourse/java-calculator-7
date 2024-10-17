package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String str = "";
        if (input.charAt(0) == '/') {
            str = String.valueOf(input.charAt(2));
            input = input.substring(5);
        }

        StringTokenizer st;
        st = new StringTokenizer(input, ",:" + str);

        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println("결과 : "+sum);
        
    }
}
