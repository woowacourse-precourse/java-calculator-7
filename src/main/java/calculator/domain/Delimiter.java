package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    final private List<Character> delimiter = new ArrayList<Character>();

    public Delimiter() {
        initDelimeter();
    }

    public Delimiter(String operand){
        initDelimeter();
        setDelimiter(operand);
        validateDelimiter(operand);
    }

    private void initDelimeter(){
        delimiter.add(',');
        delimiter.add(':');
    }

    private void validateDelimiter(String operand){
        Pattern pattern = Pattern.compile("//(.*)");
        Matcher matcher = pattern.matcher(operand);

        // 패턴에 맞지 않으면 예외를 던짐
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        // 구분자에 숫자가 포함되었는지 검사
        String delimiters = matcher.group(1);  // 구분자 그룹을 추출
        for (char delimiter : delimiters.toCharArray()) {
            if (Character.isDigit(delimiter)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void setDelimiter(String customDelimeters) {
        Pattern pattern = Pattern.compile("//(.*)");
        Matcher matcher = pattern.matcher(customDelimeters);

        if (matcher.find()) {
            String customDelimiters = matcher.group(1);  // 커스텀 구분자 추출
            for (char customDelimiter : customDelimiters.toCharArray()) {
                delimiter.add(customDelimiter);  // 커스텀 구분자 추가
            }
        }
    }

    // 구분자 리스트를 반환하는 메소드
    public String getDelimiters() {
        StringBuilder regexBuilder = new StringBuilder();

        for (int i = 0; i < delimiter.size(); i++) {
            if (i > 0) {
                regexBuilder.append("|");  // 구분자 사이에 "|" 추가
            }
            regexBuilder.append(String.valueOf(delimiter.get(i)));
        }

        return regexBuilder.toString();  // 최종 정규표현식 반환
    }

}
