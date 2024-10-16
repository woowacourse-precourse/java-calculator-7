package calculator.util;

import calculator.helper.InputHelper;

import javax.management.RuntimeErrorException;

public class NumCalculatorValidCheck {
    /**
     *
     * @param input
     * @return
     *
     */
    public static boolean isValid(String input) {
        try{
            if(input.isEmpty()) return false;
            String splitter = InputHelper.BASE_SPLITTER;
            String customSplitter = StringUtility.getCustomSplitter(input);

            boolean isCustomSplitterExists = !customSplitter.isEmpty();
            if(isCustomSplitterExists){
                splitter = customSplitter;
            }

            String numPartStr = StringUtility.getNumPart(input,isCustomSplitterExists);
            String[] numArr = numPartStr.split(splitter);
            System.out.println(splitter);
            for(String num : numArr){
                if(!StringUtility.isNumeric(num)) return false;
            }
            return true;
        }catch (RuntimeErrorException runtimeErrorException){
            return false;
        }
    }


}
