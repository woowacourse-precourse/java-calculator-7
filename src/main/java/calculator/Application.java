package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String str = readLine();
        int result = 0;
        String[] numbers;
        if (str.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        StringBuilder seperator = new StringBuilder("[:,]");
        if (str.contains("//") && str.contains("\\n")) {
            String[] divstr = str.split("\\\\n");
            String customSeparator = divstr[0].substring(2);
            seperator.insert(1, customSeparator);
            numbers = divstr[1].split(seperator.toString());
        }
        else{
            numbers = str.split(seperator.toString());
        }

        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) intArray[i] = Integer.parseInt(numbers[i].trim());

       for (int num : intArray) result += num;
       System.out.println("결과 : " + result);

    }
}
