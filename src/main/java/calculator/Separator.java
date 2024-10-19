package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_CENTER = "|";
    private static final String CUSTOM_SEPARATOR_CENTER_REGEX = "\\|";
    private static final String CUSTOM_SEPARATOR_END = "\\n";
    private String symbols;
    public Separator() {
        symbols = COMMA + CUSTOM_SEPARATOR_CENTER + COLON;
    }

    public Numbers getNumbers(String readString) {
        String numberString = readString;
        if(hasCustomSeparator(readString)){
            symbols = addCustomSeparator(readString);
            numberString = getNumberString(readString);
        }
        List<Double> numberList = split(numberString);
        return new Numbers(numberList);
    }

    private List<Double> split(String numberString) {
        List<Double> numberList;
        String[] symbolArray = symbols.split(CUSTOM_SEPARATOR_CENTER_REGEX);
        String replaceString = numberString;
        for (String symbol : symbolArray) {
            replaceString = replaceString.replace(symbol, COMMA);
        }
        String[] numberArray = replaceString.split(COMMA);
        try{
            numberList = addNumberToNumberList(numberArray);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구분자와 숫자만 입력해주세요");
        }
        return numberList;
    }

    private List<Double> addNumberToNumberList(String[] numberArray) {
        List<Double> numberList = new ArrayList<>();
        for(String s : numberArray){
            if(!s.isEmpty()){
                Double i = Double.parseDouble(s);
                numberList.add(i);
            }
        }
        return numberList;
    }

    private String getNumberString(String readString) {
        int subStringInt = readString.indexOf(CUSTOM_SEPARATOR_END) + CUSTOM_SEPARATOR_END.length();
        String substring = readString.substring(subStringInt);
        return substring;
    }

    private String addCustomSeparator(String readString) {
        String symbolsTmp = symbols;
        String substring = readString.substring(0, readString.indexOf(CUSTOM_SEPARATOR_END));
        substring = substring.replace(CUSTOM_SEPARATOR_START,"");
        if (!substring.isEmpty()) {
            symbolsTmp = symbolsTmp + CUSTOM_SEPARATOR_CENTER + substring;
        }
        return symbolsTmp;
    }

    public boolean hasCustomSeparator(String readString) {
        if(readString.contains(CUSTOM_SEPARATOR_START) && readString.contains(CUSTOM_SEPARATOR_END))return true;
        return false;
    }
}
