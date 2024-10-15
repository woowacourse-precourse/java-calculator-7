package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // //;\n1,2:3;4
        String delimiter = "[,:]";
        String customDelimiter = "";
        String input = Console.readLine();

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            customDelimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 2);
        }

        String regex = delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";
        System.out.println(regex);
        String[] inputs = input.split(regex);

        // //;\n1,2:"";4
        int sum = 0;
        for (String number : inputs) {
            number = number.trim();
            if (number.isEmpty() || number.equals("\"\"")) {
                sum += 0;
            }else {
                sum += Integer.parseInt(number);
            }
        }

        System.out.println(sum);

    }
}
