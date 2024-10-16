package calculator.util;

import calculator.helper.InputHelper;

public class NumCalculatorValidCheck {
    /**
     *
     * @param input
     * @return
     * TODO refactoring spliter valid와 numPart valid 분리하여 메소드화 하기
     */
    public static boolean isValid(String input) {
        try{
            if(input.isEmpty()) return true;
            String splitter = InputHelper.BASE_SPLITTER;
            String customSplitter = StringUtility.getCustomSplitter(input);

            boolean isCustomSplitterExists = !customSplitter.isEmpty();
            if(isCustomSplitterExists){
                splitter = customSplitter;
            }

            String numPartStr = StringUtility.getNumPart(input,isCustomSplitterExists);
            String[] numArr = numPartStr.split(splitter);
            for(String num : numArr){
                if(!isNumeric(num)) return false;
                if(!isInRange(num)) return false;
            }
            return true;
        }catch (RuntimeException runtimeException){
            return false;
        }
    }


    public static boolean isNumeric(String numStr) {
        try{
            Integer.parseInt(numStr);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isInRange(String numStr) {
        try{
            if(Integer.parseInt(numStr) >= 0) return true;
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
