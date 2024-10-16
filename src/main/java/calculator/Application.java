package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String str = "";
        if(input.charAt(0) == '/') {
            str = String.valueOf(input.charAt(2));
        }

        StringTokenizer st;
        st = new StringTokenizer(input.substring(5),",:"+str);
        
        int sum = 0;
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
    }
}
