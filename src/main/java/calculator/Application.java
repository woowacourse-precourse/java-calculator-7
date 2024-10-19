package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String UserInput = valueInput();
        String matcherCheck = "[0-9]+";
        int StartIndex = 0;
        String AllSeparator;

        if (UserInput.isEmpty()) {
            resultPrint(0);
            return;
        }

        if (hasPattern(UserInput)) {
            AllSeparator = ",|:|" + UserInput.substring(2);
            StartIndex = 5;
        } else {
            AllSeparator = ",|:";
        }

        String[] NumberList =
                UserInput.substring(StartIndex).split(AllSeparator);

        int result = 0;

        for (String s : NumberList) {
            if (s.matches(matcherCheck)) {
                result += Integer.parseInt(s);
            } else if (s.matches("")) {
                result += 0;
            } else {
                throw new IllegalArgumentException();
            }
        }

        resultPrint(result);
    }


    static String valueInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    static boolean hasPattern(String input) {
        try {
            String checkMobile = input.substring(0, 5);
            return checkMobile.contains("//") & checkMobile.contains("\\n");
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    static void resultPrint(int AllCombinedValues) {
        System.out.println("결과 : " + AllCombinedValues);
    }
}
