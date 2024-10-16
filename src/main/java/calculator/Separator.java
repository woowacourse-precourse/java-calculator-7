package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_SEPARATOR_START= "//";
    private static final String CUSTOM_SEPARATOR_END= "\\n";
    private String symbols;
    public Separator() {
        symbols = COMMA + COLON;
    }

    public Numbers getNumbers(String readString) {
        String numberString = readString;
        if(hasCustomSeparator(readString)){
            addCustomSeparator(readString);
            numberString = getNumberString(readString);
        }
        List<Integer> numberList = split(numberString);
        return new Numbers(numberList);
    }

    private List<Integer> split(String numberString) {
        List<Integer> numberList = new ArrayList<>();
        String[] symbolArray = symbols.split("");
        String replaceString = numberString;
        for (String symbol : symbolArray) {
            replaceString = replaceString.replace(symbol, COMMA);
        }
        String[] numberArray = replaceString.split(COMMA);
        try{
            for(String s : numberArray){
                int i = Integer.parseInt(s);
                numberList.add(i);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구분자와 숫자만 입력해주세요");
        }
        return numberList;
    }

    private String getNumberString(String readString) {
        int subStringInt = readString.indexOf(CUSTOM_SEPARATOR_END) + CUSTOM_SEPARATOR_END.length();
        String substring = readString.substring(subStringInt);
        return substring;
    }

    private void addCustomSeparator(String readString) {
        String substring = readString.substring(0, readString.indexOf(CUSTOM_SEPARATOR_END));
        substring = substring.replace(CUSTOM_SEPARATOR_START,"");
        if (!substring.isEmpty()) {
            symbols = symbols +substring;
        }
    }

    private boolean hasCustomSeparator(String readString) {
        if(readString.contains(CUSTOM_SEPARATOR_START) && readString.contains(CUSTOM_SEPARATOR_END))return true;
        return false;
    }
}
