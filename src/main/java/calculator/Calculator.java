package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() throws IllegalArgumentException {
        String input = Console.readLine();
        int sum = 0;
        String[] inputSplit;

        if (input.startsWith("//")) {
            int start = input.indexOf("\\n");
            if (start == -1) throw new IllegalArgumentException("잘못된 입력입니다: " + input);
            String delimiter = input.substring(2, start);
            String num = input.substring(start + 2);
            inputSplit = num.split(delimiter);
        }
        else inputSplit = input.split(",|:");

        if (!input.isEmpty())
            for (int i = 0; i < inputSplit.length; i++) {
                int num = 0;
                if (isNumber(inputSplit[i])) num = Integer.parseInt(inputSplit[i]);
                if (num < 0) throw new IllegalArgumentException("잘못된 입력입니다: " + num);
                sum += num;
            }

        System.out.println("결과 : " + sum);
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("입력된 값이 숫자가 아닙니다: " + str);
            throw e;
        }
        return true;
    }
}