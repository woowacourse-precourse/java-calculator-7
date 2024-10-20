package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String[] result = input.split("[:,]");
        System.out.println(Arrays.toString(result));

    }
}
