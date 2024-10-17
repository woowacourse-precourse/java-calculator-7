package calculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//계산기의 전반적인 기능을 담당하는 클래스
public class CalculateService {

    private List<String> delimeters = new ArrayList<>(Arrays.asList(",", ":"));

    private static final String customDelimeterPrefix = "//";
    private static final String customDelimeterPostfix = "\\n";

    //임시 메서드
    public Long calculate(final String userInput) {

        addDelimeter(userInput);
        return null;
    }

    //custom Delimeter 존재시 delimeter 에 넣기
    private void addDelimeter(final String userInput) {

        int firstIndexOfPrefix = userInput.indexOf(customDelimeterPrefix);
        int firstIndexOfPostfix = userInput.indexOf(customDelimeterPostfix);

        checkDelimterForm(firstIndexOfPrefix, firstIndexOfPostfix);

        if (hasCustomDelimeter(firstIndexOfPrefix, firstIndexOfPostfix)) {
            delimeters.add(userInput.substring(firstIndexOfPrefix + 2, firstIndexOfPostfix));
        }


    }

    //올바른 Deliter 형식인지 판단할 것!
    private void checkDelimterForm(int firstIndexOfPrefix, int firstIndexOfPostfix) {

    }

    private boolean hasCustomDelimeter(int firstIndexOfPrefix, int firstIndexOfPostfix) {

        if (firstIndexOfPrefix == -1 && firstIndexOfPostfix == -1) {
            return false;
        }

        return true;
    }


}
