package calculator.util;

import calculator.helper.InputHelper;

public class StringUtility {
    /*
    커스텀 구분자가 존재한다면, 항상 문자열의 제일 앞에 존재하며 문자가 항상 존재해야합니다.
     */
    public static String getCustomSplitter(String input) {
        if(input.isEmpty()) return "";

        int splitterEndCount = getStrCount(InputHelper.SPLITTER_END_REGEX,input);
        int splitterStartCount = getStrCount(InputHelper.SPLITTER_START_REGEX,input);

        if(splitterEndCount == 0 && splitterStartCount == 0) return "";

        if(splitterEndCount == 1 && splitterStartCount == 1){
            System.out.println(input.indexOf(InputHelper.SPLITTER_END));
            if(input.indexOf(InputHelper.SPLITTER_START) != InputHelper.SPLITTED_START_IDX) throw new IllegalArgumentException(InputHelper.INVALID_CUSTOM_SPLITTER);
            if(input.indexOf(InputHelper.SPLITTER_END) != InputHelper.SPLITTED_END_IDX) throw new IllegalArgumentException(InputHelper.INVALID_CUSTOM_SPLITTER);
            System.out.println(input);
            char splitter = input.charAt(InputHelper.SPLITTED_END_IDX-1);
            if(Character.isDigit(splitter)) throw new IllegalArgumentException(InputHelper.INVALID_CUSTOM_SPLITTER);
            return splitter + "";
        }

        throw new IllegalArgumentException(InputHelper.INVALID_CUSTOM_SPLITTER);
    }

    public static int getStrCount(String regex, String input) {
        return input.split(regex).length-1;
    }


    public static String getNumPart(String input,boolean customSplitterExists) {
        if(customSplitterExists){
            return input.split(InputHelper.SPLITTER_END_REGEX)[1];
        }

        return input;
    }

    public static boolean isNumeric(String num) {
        try{
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
