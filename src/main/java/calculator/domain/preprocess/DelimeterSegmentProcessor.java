package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.utils.Util.isInteger;

public class DelimeterSegmentProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            validateCutomDelimeterRequest(input);
            return true;
        } else
            return false;
    }

    private void validateCutomDelimeterRequest(String input) {
        if (input.indexOf("\n") == 2)
            throw new IllegalArgumentException("구분자로 사용할 문자 미입력");
        if (input.indexOf("\n") > 3)
            throw new IllegalArgumentException("구분자로 사용할 문자가 두 글자 이상");
        if(isInteger(Character.toString(input.charAt(2))))
            throw new IllegalArgumentException("구분자로 숫자를 사용할 수 없습니다");
    }

    public String extractCustomDelimeter(String input) {
        String delimeter = Character.toString(input.charAt(2));
        return delimeter;
    }

    public String extractCalculationSegment(String input) {
        String newInput = input.substring(4);
        return newInput;
    }

    public List<String> makeDelimeterList(String delimeter) {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));
        delimeterList.add(delimeter);
        return delimeterList;
    }
}
