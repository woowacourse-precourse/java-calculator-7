package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() {
        String input = Console.readLine();

        try {
            int sum = calculate(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private int calculate(String input) {
        if (input.isEmpty()) return 0;

        String[] inputSplit = splitStr(input);
        return sumNumber(inputSplit);
    }

    private String[] splitStr(String str) {
        String delimiter = ",|:";
        if (str.startsWith("//")) {
            int start = str.indexOf("\\n");
            if (start == -1)
                throw new IllegalArgumentException("잘못된 입력입니다: " + str);
            str = str.substring(start + 2);
        }

        return str.split(delimiter);
    }

    private int sumNumber(String[] str) {
        int sum = 0;
        int num = 0;

        for (String s : str) {
            if (isNumber(s)) num = Integer.parseInt(s);
            if (num < 0)
                throw new IllegalArgumentException("잘못된 입력입니다: " + num);
            sum += num;
        }

        return sum;
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