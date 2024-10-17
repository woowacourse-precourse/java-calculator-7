package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static Boolean CustomDiscrimination(String input){
        if (input.startsWith("//") && input.contains("\\n"))
            return true;
        else if (!input.startsWith("//") && !input.contains("\\n"))
            return false;
        else
            throw new IllegalArgumentException();
    }

    public static String CustomExtraction(String customInput){
        String extraction = customInput.substring(customInput.indexOf("//") + 2, customInput.indexOf("\\n"));
        if (extraction.length() > 1 || extraction.matches("\\d+"))
            throw new IllegalArgumentException();
        return extraction;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        ArrayList<String> separate = new ArrayList<>(Arrays.asList(",", ":"));
        if (CustomDiscrimination(str)){
            separate.add(CustomExtraction(str));
        }


    }
}
