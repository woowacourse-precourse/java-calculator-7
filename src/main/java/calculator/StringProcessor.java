package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private List<String> readStringList;
    private List<Double> numberList;

    public StringProcessor(String readString) {
        String[] stringArray = splitString(readString);
        readStringList = new ArrayList<>();
        validateString(stringArray);
        stringTONumber(readStringList);
    }

    private String[] splitString(String readString) {
        String basic = ",:";
        String custom =  "//(.*)\\\\n";;
        Pattern pattern = Pattern.compile(custom);
        Matcher matcher = pattern.matcher(readString);
        if (matcher.find()){
            custom =  "//\\\\n" + matcher.group(1);
            return readString.split("["+basic+custom+"]");
        }
        return readString.split("["+basic+"]");
    }

    private void stringTONumber(List<String> readStringList) {
        numberList = new ArrayList<>();
        for (String s : readStringList){
            this.numberList.add(Double.parseDouble(s));
        }
    }

    private void validateString(String[] stringArray) {
        for (String s : stringArray){
            if (s.isEmpty()){
                continue;
            }
            validate(s);
            readStringList.add(s);
        }
    }

    private void validate(String s) {
        invalidString(s);
        validateRange(s);
    }

    private void invalidString(String s) {
        if (!s.matches("[0-9\\.\\-]*")){
            throw new IllegalArgumentException("[ERROR] 허용되지 않은 문자열이 포함되어있습니다.");
        }
    }
    private void validateRange(String s) {
        if (Double.parseDouble(s) < 0){
            throw new IllegalArgumentException("[ERROR] 양수만 허용합니다.");
        }
    }

}
