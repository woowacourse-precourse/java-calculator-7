package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterSplitter {

    private String target;
    private List<Delimiter> delimiter;

    public DelimiterSplitter(String target, List<Delimiter> delimiter) {
        this.target = target;
        this.delimiter = delimiter;
    }

    public List<Number> splitByDelimiter() {
        String regex = String.join("|", changeDelimiterToStringList(delimiter));
        String trimmedTarget = target.replaceAll("^(" + regex + ")+|(" + regex + ")+$", ""); //문자열의 앞뒤에 있는 구분자를 제거
        String[] split = trimmedTarget.split(regex);
        return changeToNumber(split);
    }

    private List<Number> changeToNumber(String[] result) {
        List<Number> resultNumbers = new ArrayList<>();
        for (String value : result) {
            resultNumbers.add(Number.from(value));
        }
        return resultNumbers;
    }

    private List<String> changeDelimiterToStringList(List<Delimiter> delimiters) {
        return delimiters.stream()
                .map(Delimiter::getValue)
                .toList();
    }
}
