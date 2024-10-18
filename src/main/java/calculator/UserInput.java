package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private String customDelimiter;
    private String delimiterSection;
    private String numberString;
    private String input;
    private String regex = "^(\\/\\/)([^a-zA-Z0-9.: ]{1})";

    public UserInput(String input) {
        this.input = input;
        init();
    }

    private void init() {
        separateDelimAndNumbers(); // 구분자 섹션과 숫자 섹션 분리
    }

    public void separateDelimAndNumbers() {
        String[] split = input.split("\\\\n");
        if(split.length==1) { // 커스텀 구분자가 존재하지 않는 경우
            numberString = split[0];
        }else if(split.length==2) {
            delimiterSection = split[0];
            numberString = split[1];
            extractDelimiter(delimiterSection);
        }else {
            throw new IllegalArgumentException("커스텀 구분자 형식이 일치하지 않습니다.");
        }
    }

    private void extractDelimiter(String delimiterSection) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(delimiterSection);
        if(matcher.matches()) {
            customDelimiter = matcher.group(2);
        }else {
            throw new IllegalArgumentException("커스텀 구분자 형식이 일치하지 않습니다.");
        }
    }
    public boolean isCustomDelimiterPresent() {
        return customDelimiter != null;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public String getNumberString() {
        return numberString;
    }

    public static void main(String[] args) {
        new UserInput("//;\n1;2;3");
    }

}
