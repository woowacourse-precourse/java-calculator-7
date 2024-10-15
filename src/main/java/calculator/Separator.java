package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String OR = "|";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private String symbols;
    public Separator() {
        symbols = COMMA + OR + COLON;
    }

    public List<Integer> getNumberList(String readString) {
        List<Integer> numberList = new ArrayList<>();
        String numberString = readString;
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
}
