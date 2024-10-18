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

    public List<Long> extractNumbers(String inputValue) throws IllegalArgumentException{
        String replacedValue = normalizeSeparator(inputValue);
        List<String> splitValue = separate(replacedValue);

        try {
            return splitValue.stream()
                    .filter(i-> !i.isEmpty()) // 구분자가 연속으로 오는 경우 ""이 올 수 있으므로 이를 필터링.
                    .map(Long::valueOf)
                    .peek(i-> {
                        if(i<0) throw new IllegalArgumentException("음수는 입력이 불가합니다");
                    })
                    .toList();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    public List<String> separate(String replacedValue){
        return Arrays.asList(replacedValue.split(REPLACE_SEPARATOR,-1));
    }

    // 구분자를 전부 ','으로 통일.
    public String normalizeSeparator(String inputValue){
        for(String separator: separators){
            inputValue = inputValue.replaceAll(Pattern.quote(separator), REPLACE_SEPARATOR);
        }
        return inputValue;
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
