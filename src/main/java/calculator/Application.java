package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int StartIndex = Constant.ZERO;
        int Result = Constant.ZERO;

        String UserInput = valueInput();
        String AllSeparator;

        if (UserInput.isEmpty()) {
            resultPrint(Constant.ZERO);
            return;
        }

        if (hasPattern(UserInput)) {
            AllSeparator = ",|:|" + UserInput.substring(Constant.CUSTOM_PATTERN_INDEX);
            StartIndex = Constant.CUSTOM_PATTERN_STARTINDEX;
        } else {
            AllSeparator = ",|:";
        }

        String[] NumberList =
                UserInput.substring(StartIndex).split(AllSeparator);

        for (String s : NumberList) {
            if (s.matches(Constant.MATCHER_CHECK)) {
                Result += Integer.parseInt(s);
            } else if (s.matches("")) {
                Result += Constant.ZERO;
            } else {
                throw new IllegalArgumentException();
            }
        }

        resultPrint(Result);
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
