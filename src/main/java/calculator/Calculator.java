package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;


public class Calculator {
    public Calculator(ArrayList<Integer> intList) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        Total total = new Total(readLine());
        System.out.println(total);
    }

    
}
