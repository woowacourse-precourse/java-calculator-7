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
        if(!Validation.isRightInput(input)) throw new IllegalArgumentException("입력값이 맞지 않습니다.");

        //구분자 넣기
        addDelimiter();

        //구분 결과
        return addResultValues(getDelimiterSplitValues());
    }

    //커스텀 구분자 추가하기
    private void addDelimiter() {
        //첫 부분 패턴이 있을 경우 해당 구분자를 출력해 set에 저장
        Pattern pattern = Pattern.compile(delimiterPattern);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String match = matcher.group();
            String delimiter = match.replaceAll("(//|\\\\n)", "");
            //만약 구분자가 "\"인 경우 regex에서는 "\\"여야 하기 때문에 아래의 조건문 추가
            if(delimiter.startsWith("\\")) {
                delimiterSet.add("\\" + delimiter);
            } else {
                delimiterSet.add(delimiter);
            }
        }
    }

    //저장된 구분자들을 통해 분리한 값 가져오기
    private String[] getDelimiterSplitValues(){
        //구분자 추가하는 문자열을 전부 제거 -> 뒤에 있는 숫자 + 구분자 형식의 문자열만 남게된다.
        String removePattern = input.replaceAll(delimiterPattern, "");

        // set에 있는 구분자들을 이용해 regex를 만드는 과정 -> set이 [:, ., ;]인 경우 [:.;] 출력하도록 구현
        String regex = "[" + delimiterSet.stream().map(String::valueOf).collect(Collectors.joining("")) + "]";

        //regex를 이용해 구분자 split을 구현
        return removePattern.split(regex);
    }

    private int addResultValues(String[] values) {
        //숫자 변환 실패 -> 저장이 안된 구분자 존재
        if(!Validation.isRightFormatNumber(values)) throw new IllegalArgumentException("구분자가 포함되어 있습니다");

        //검증 성공 시 결과 도출
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    //설정된 구분자 가져오기
    private Set<String> getDelimiterSet() {
        addDelimiter();
        return delimiterSet;
    }
}