package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimeterProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.contains("\n"))
            return true;
        else
            return false;
    }

    public void validateCutomDelimeterRequest(String input) {
        if (input.indexOf("\n") == 2)
            throw new IllegalArgumentException("구분자로 사용할 문자 미입력");
        if (input.indexOf("\n") > 3)
            throw new IllegalArgumentException("구분자로 사용할 문자가 두 글자 이상");
    }

    public String extractCustomDelimeter(String input) {
        String delimeter = Character.toString(input.charAt(2));
        return delimeter;
    }

    public String discardCustomDelimeterRequest(String input){
        String newInput = input.substring(4);
        return newInput;
    }

    public List<String> makeDelimeterList(String delimeter){
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",",":"));
        delimeterList.add(delimeter);
        return delimeterList;
    }
}
