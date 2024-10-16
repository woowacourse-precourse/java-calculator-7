package calculator.util;

import calculator.helper.InputHelper;

import javax.management.RuntimeErrorException;

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
                if(!StringUtility.isNumeric(num)) return false;
                if(!StringUtility.isInRange(num)) return false;
            }
            return true;
        }catch (RuntimeException runtimeException){
            return false;
        }
    }


}
