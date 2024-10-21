package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private final String input;
    private final Set<String> delimiterSet = new HashSet<>(List.of(":", ","));
    private final String delimiterPattern = "//\\D\\\\n";

    public Calculator(String input) {
        this.input = input;
    }

    public int getResult() {
        //입력 조건 실패시 오류 발생
        if(!Validation.inputCheck(input)) throw new IllegalArgumentException("입력값이 맞지 않습니다.");
        customDelimiter();

        return addResultValues(getDelimiterSplitValues());
    }

    //커스텀 구분자 추가하기
    private void customDelimiter() {
        Pattern pattern = Pattern.compile(delimiterPattern);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            String delimiter = match.replaceAll("(//|\\\\n)", "");

            if(delimiter.startsWith("\\")) {
                delimiterSet.add("\\" + delimiter);
            } else {
                delimiterSet.add(delimiter);
            }
        }
    }

    private String[] getDelimiterSplitValues(){
        String removePattern = input.replaceAll(delimiterPattern, "");

        String regex = "[" + delimiterSet.stream().map(String::valueOf).collect(Collectors.joining("")) + "]";

        return removePattern.split(regex);
    }

    private int addResultValues(String[] values) {
        if(!Validation.formatCheck(values)) throw new IllegalArgumentException("구분자가 포함되어 있습니다");

        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private Set<String> getDelimiterSet() {
        customDelimiter();
        return delimiterSet;
    }
}