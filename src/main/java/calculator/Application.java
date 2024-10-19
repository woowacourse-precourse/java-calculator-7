package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num;
        int endex;
        int sum = 0;
        String sep = ",|:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //String input = Console.readLine();
        String input = "//!!!\n3,4!!!5:8";

        if (input.startsWith("//")) {
            endex = input.indexOf("\n");
            if (endex == -1) {
                throw new IllegalArgumentException("Unavailable format. Check your input.");
            }
            String c_sep = input.substring(2, endex);
            if("(){}[]\\*+?^$|".contains(c_sep)){
                c_sep = "\\" + c_sep;
            }
            sep = sep + "|" + c_sep;
            input = input.substring(endex + 1);
        }
        else if(input.contains("//")){
            throw new IllegalArgumentException("Custom Separator Grammar must be placed at the first.");
        }

        String[] value = input.split(sep);
        if (value.length == 0) {
            System.out.println("결과 : 0");
            return;
        } else {
            for (String v : value) {
                try {
                    num = Integer.parseInt(v);
                    if (num < 0) {
                        throw new IllegalArgumentException("The number should be positive. Error number = " + num);
                    }
                    sum = sum + num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Not allowed separator is used.");
                }
            }
        }
        System.out.println("결과 : " + sum);

    }
}
