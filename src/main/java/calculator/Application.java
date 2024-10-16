package calculator;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        if(!isEmpty(input)){
            ArrayList<String> str = splitToArrayList(input);
            System.out.println(str);
        } else {
            System.out.println("결과 : 0");
        }
    }

    public static boolean isEmpty(String str){
        return str.length() == 0;
    }

    public static ArrayList<String> splitToArrayList(String input) {
        String[] splitValues = input.split("[,;]");
        return new ArrayList<>(Arrays.asList(splitValues));
    }
}
