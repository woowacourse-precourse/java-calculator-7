package calculator.domain;

import java.util.*;
import java.util.regex.Pattern;

import static calculator.constant.Constant.DEFAULT_SEPARATOR_COLON;
import static calculator.constant.Constant.DEFAULT_SEPARATOR_COMMA;


public class Separator {
    private final Set<String> separators;
    private static final String REPLACE_SEPARATOR = DEFAULT_SEPARATOR_COMMA;

    public Separator(){
        this.separators = new HashSet<>(
                Arrays.asList(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON));
    }

    public String processCustomSeparator(String inputValue){
        String[] separatedInput = parseSeparatorAndValue(inputValue);
        addSeparator(separatedInput[0]);
        return separatedInput[1];
    }

    public boolean isExistCustomSeparator(String inputValue){
        return inputValue.startsWith("//");
    }

    //문자열을 커스텀 구분자와 그 외 입력 문자열로 나눔. 이때 '\\n'을 기준으로 나누므로 정규식을 '\\\\n'으로 작성해줌.
    private String[] parseSeparatorAndValue(String inputValue){
        return inputValue.substring(2).split("\\\\n",2);
    }

    private void addSeparator(String customSeparator){
        this.separators.add(customSeparator);
    }

}
