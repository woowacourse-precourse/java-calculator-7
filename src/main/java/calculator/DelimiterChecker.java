package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterChecker {

    private String target;
    private List<Delimiter> delimiter;

    public DelimiterChecker(String target, List<Delimiter> delimiter) {
        this.target = target;
        this.delimiter = delimiter;
    }

    public List<Integer> splitByDelimiter() {
        String regex = String.join("|", changeDelimiterToStringList(delimiter));
        String trimmedTarget = target.replaceAll("^(" + regex + ")+|(" + regex + ")+$", ""); //문자열의 앞뒤에 있는 구분자를 제거
        String[] split = trimmedTarget.split(regex);
        List<Integer> result = changeToNumber(split);
        return result;
    }

    private List<Integer> changeToNumber(String[] result) {
        List<Integer> resultNumbers = new ArrayList<>();
        for (String value : result) {
            try {
                if(value.isEmpty())
                    throw new IllegalArgumentException("구분자 사이에는 1개 이상의 숫자를 넣어야합니다.");
                int tempNum = Integer.parseInt(value);
                if(tempNum < 0)
                    throw new IllegalArgumentException("정수로 변환할 수 있는 양수만 계산할 수 있습니다: " + value);
                resultNumbers.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수로 변환할 수 있는 양수만 계산할 수 있습니다: " + value);
            }
        }
        return resultNumbers;
    }

    private List<String> changeDelimiterToStringList(List<Delimiter> delimiters) {
        return delimiters.stream()
                .map(Delimiter::getValue)
                .toList();
    }
}
