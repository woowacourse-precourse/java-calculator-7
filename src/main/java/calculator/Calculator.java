package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() {
        String input = Console.readLine();
        int sum = 0;
        String[] inputSplit;

        if (input.startsWith("//")) {
            int start = input.indexOf("\\n");
            String delimiter = input.substring(2, start);
            String num = input.substring(start + 2);
            inputSplit = num.split(delimiter);
        }
        else inputSplit = input.split(",|:");

        if (!input.isEmpty())
            for (int i = 0; i < inputSplit.length; i++)
                sum += Integer.parseInt(inputSplit[i]);

        System.out.println("결과 : " + sum);
    }
}