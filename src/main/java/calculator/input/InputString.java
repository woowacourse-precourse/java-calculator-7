package calculator.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputString {

    private static String inputString = "";
    //private static List<String> separators = new ArrayList<>();

    public String input(){ //문자열 입력받기
        inputString = readLine();

        //List<Integer> number = findSeparator(inputString);

        return inputString;
    }
}
