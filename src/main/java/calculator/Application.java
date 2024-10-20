package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {

    static String result;
    static List<Integer> numbers;

    public static void main(String[] args) {

        // 입력
        System.out.println(Constants.REQUEST);
        String rawString = Console.readLine();

        //문자열 가공
        numbers = StringProcessing.processString(rawString);

        //계산
        result = Calculator.sumNumbers(numbers);
        System.out.print(Constants.RESULT+result);





    }
}
