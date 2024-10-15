package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String OR = "|";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_SEPARATOR_START= "//";
    private static final String CUSTOM_SEPARATOR_END= "\\n";
    private String symbols;
    public Separator() {
        symbols = COMMA + OR + COLON;
    }

    public List<Integer> getNumberList(String readString) {
        List<Integer> numberList = new ArrayList<>();
        String numberString = readString;
        if(hasCustomSeparator(readString)){
            addCustomSeparator(readString);
            numberString = getNumberString(readString);
        }
        String[] split = numberString.split(symbols);
        try{
            for(String s : split){
                int i = Integer.parseInt(s);
                numberList.add(i);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구분자와 숫자만 입력해주세요");
        }
        return numberList;
    }

    private String getNumberString(String readString) {
        String substring = readString.substring(readString.indexOf(CUSTOM_SEPARATOR_END)+ CUSTOM_SEPARATOR_END.length());
        return substring;
    }

    private void addCustomSeparator(String readString) {
        String substring = readString.substring(0, readString.indexOf(CUSTOM_SEPARATOR_END));
        substring = substring.replace(CUSTOM_SEPARATOR_START,"");
        symbols = symbols + OR +substring;
    }

    private boolean hasCustomSeparator(String readString) {
        if(readString.contains(CUSTOM_SEPARATOR_START) && readString.contains(CUSTOM_SEPARATOR_END))return true;
        return false;
    }
}
