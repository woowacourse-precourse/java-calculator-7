package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int StartIndex;
        long Result;

        boolean PatternEnable;

        String AllSeparator;
        String UserInput;

        System.out.println(Constant.INPUT_MESSAGE);
        UserInput = valueInput();

        if (UserInput.isEmpty()) {
            resultPrint(Constant.ZERO);
            return;
        }

        PatternEnable = hasPattern(UserInput);
        AllSeparator = SeparatorSetting(UserInput, PatternEnable);
        StartIndex = StartIndexSetting(PatternEnable);

        String[] NumberList = UserInput.substring(StartIndex).split(AllSeparator);
        Result = SumNumericValues(NumberList);
        resultPrint(Result);
    }

    public static long SumNumericValues(String[] NumberList) {
        long Result = Constant.ZERO;
        for (String s : NumberList) {
            if (s.matches(Constant.MATCHER_CHECK)) {
                Result += Integer.parseInt(s);
            } else if (s.matches(Constant.NONE_INPUT)) {
                Result += Constant.ZERO;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return Result;
    }

    private static int StartIndexSetting(boolean patternEnable) {
        if (patternEnable) {
            return Constant.CUSTOM_PATTERN_STARTINDEX;
        } else {
            return Constant.ZERO;
        }
    }

    private static String SeparatorSetting(String UserInput, boolean patternEnable) {
        if (patternEnable) {
            return Constant.PATTERN_ENABLE + UserInput.charAt(Constant.CUSTOM_PATTERN_INDEX);
        } else {
            return Constant.PATTERN_DISABLE;
        }
    }

    static String valueInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return Constant.NONE_INPUT;
        }
    }

    static boolean hasPattern(String input) {
        try {
            String checkMobile = input.substring(Constant.ZERO, Constant.PATTERN_CHECK_LAST_POSITION);
            return checkMobile.contains(Constant.PATTERN_CHECK_FIRST_TEXT)
                    & checkMobile.contains(Constant.PATTERN_CHECK_LAST_TEXT);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    static void resultPrint(long AllCombinedValues) {
        System.out.println(Constant.END_MESSAGE + AllCombinedValues);
    }
}
