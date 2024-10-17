package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String str = readLine();

        String delimiter = ",|:";
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\n");
            delimiter = str.substring(2, delimiterIndex);
            str = str.substring(delimiterIndex + 1);
        }

        String[] numbers = str.split(delimiter);
        int sum = 0;

        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }

        System.out.println("결과 : " + sum);

    }
}
