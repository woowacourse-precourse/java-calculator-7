package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        int[] result2 = new int[result.length];
        int dap = 0;

        String input = Console.readLine();
        String[] result = input.split("[:,]");

        for(int i=0;i< result.length;i++){
            result2[i] = Integer.parseInt(result[i]);
        }

        for (int j : result2) {
            dap += j;
        }
        System.out.println(dap);
    }
}
