package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int result = 0;
        List<String> seperator = new ArrayList<>();
        seperator.add(",");
        seperator.add(";");

        if (input.startsWith("//") && input.charAt(3) == 92 && input.charAt(4) == 'n') {
            char customSeperatorChar = input.charAt(2);
            String cumtomSeperator = Character.toString(customSeperatorChar);
            seperator.add(cumtomSeperator);
        }

        String[] splitedInput = input.split(",|;");
        for (String inputNumber : splitedInput) {
            int number = Integer.parseInt(inputNumber);
            result += number;
        }

//        System.out.println("결과 : " + result);
    }
}
