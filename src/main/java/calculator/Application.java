package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {

    static String result;
    static List<Integer> numbers;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(Constants.REQUEST);
        String rawString = Console.readLine();

        //문자열 가공
        numbers = StringProcessing.processString(rawString);
        System.out.println(numbers);




    }
}
