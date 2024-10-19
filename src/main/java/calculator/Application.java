package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if(input.isEmpty()){
            System.out.println("result : 0" );
            return;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, endIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
            input = input.substring(endIndex + 2);
        }

        String[] inputNumbers = input.split(delimiter);

        int sum = 0;

        for (String numberString : inputNumbers) {
            if (numberString.trim().isEmpty()) continue;

            try {
                int number = Integer.parseInt(numberString.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("invalid value(negative integer)" + number);
                }
                sum += number;
            } catch (IllegalArgumentException e) {
                System.out.println("invalid value(not integer)");
                return;
            }
        }

        System.out.println("result : " + sum);
    }
}
