package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.utils.Util.isInteger;

public class DelimeterSegmentProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            validateCustomDelimeterRequest(input);
            return true;
        } else
            return false;
    }

    //구분자가 두 글자 이상일 경우 가령 ",," 와 같은 것을 구분자로 받는 경우 기존의 구분자와 충돌이 발생할 수 있다고 판단하여 제한.
    private void validateCustomDelimeterRequest(String input) {
        if (input.indexOf("\n") == 2)
            throw new IllegalArgumentException("구분자로 사용할 문자 미입력");
        if (input.indexOf("\n") > 3)
            throw new IllegalArgumentException("구분자로 사용할 문자가 두 글자 이상");
        if (isInteger(Character.toString(input.charAt(2))))
            throw new IllegalArgumentException("구분자로 숫자를 사용할 수 없습니다");
    }

    public String extractCalculationSegment(String input) {
        return input.substring(4);
    }

    public List<String> extractDelimeterList(String input) {
        String delimeter = Character.toString(input.charAt(2));
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));
        delimeterList.add(delimeter);
        return delimeterList;
    }
}
