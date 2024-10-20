package calculator;

import java.text.DecimalFormat;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String REGEX = "[,:]";
        System.out.println("덧셈할 문자열을 입력해주세요");

        String user_input = "";
        try {
            user_input = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.print("결과 : 0");
            return;
        }

        if (user_input.startsWith("//")) {
            int endIndex = user_input.indexOf("\\n");
            REGEX = user_input.substring("//".length(), endIndex);
            user_input = user_input.substring(endIndex + "\\n".length());
        }

        float result = 0;
        String[] a_arr = user_input.split(REGEX);
        for (String s : a_arr) {
            try {
                float number = Float.parseFloat(s);
                if (number >= 0) {
                    result += Float.parseFloat(s);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.printf("결과 : %s", df.format(result));
    }
}
