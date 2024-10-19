package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private List<String> separators;

    public Delimiters(String rawString) {
        this.separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");
        separators.add("//");
        separators.add("\\n");
        findCustomSeparator(rawString);
        checkNotDelimiter(rawString);
    }

    private void checkNotDelimiter(String rawString) {
        String regex = "[^" + String.join("", separators) + "0-9]+";
        Matcher matcher = Pattern.compile(regex).matcher(rawString);

        while (matcher.find()) {
            throw new IllegalArgumentException("구분자 외 문자는 입력할 수 없습니다.");
        }
    }

    private void findCustomSeparator(String rawString) {
        Matcher matcher = Pattern.compile("(?<=//)(.*?)(?=\n)").matcher(rawString);
        while (matcher.find()) {
            separators.add(matcher.group());
        }
    }
}
